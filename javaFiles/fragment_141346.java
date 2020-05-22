import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.util.*;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.lang.StringEscapeUtils;

public class BeanCodeGenerator {

    private class Context {
        private int index;
        private StringBuilder sb = new StringBuilder();
        private String br = "\n\t\t";
    }

    public String generateBeanMethod(Object bean, String methodName) {
        Context ctx = new Context();
        Class type = _getBeanClass(bean);
        ctx.sb.append("\tpublic ").append(type.getCanonicalName()).append(" ").append(methodName)
            .append("() {").append(ctx.br);

        String vname = "null";
        try {
            vname = _valueStr(bean, type, ctx);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        ctx.sb.append("return ").append(vname).append(";\n");
        ctx.sb.append("\t}\n");
        return ctx.sb.toString();
    }

    private String _outputBean(Object bean, Context ctx) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        // output block of code creating bean
        String vname = "v" + ctx.index;
        String cname = bean.getClass().getCanonicalName();
        ctx.sb.append(cname).append(" ").append(vname).append(" = new ").append(cname).append("();").append(ctx.br);
        PropertyDescriptor[] props = PropertyUtils.getPropertyDescriptors(bean);
        for (PropertyDescriptor prop : props) {
            if (prop.getReadMethod() == null || prop.getWriteMethod() == null)
                continue; // skip such 'properties'
            Object value = prop.getReadMethod().invoke(bean);
            if (value == null)
                continue;
            String valueStr = _valueStr(value, prop.getReadMethod().getReturnType(), ctx);
            if (valueStr != null) {
                ctx.sb.append(vname).append(".").append(prop.getWriteMethod().getName()).append("(")
                    .append(valueStr).append(");").append(ctx.br);
            }
        }
        return vname;
    }

    private Class _getBeanClass(Object bean) {
        if (bean == null)
            return null;
       if (_isCollection(bean)) {
           if (bean instanceof List)
               return ArrayList.class;
           if (bean instanceof Set)
               return HashSet.class;
           if (bean instanceof Map)
               return HashMap.class;
       }
       return bean.getClass();
    }

    private String _valueStr(Object value, Class type, Context ctx) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        String valueStr = _outputValue(value, type);
        if (valueStr == null) {
            if (_isBean(value)) {
                ctx.index++;
                valueStr = _outputBean(value, ctx);
            } else if (_isCollection(value)) {
                ctx.index++;
                valueStr = _outputCollection(value, ctx);
            }
        }
        if (valueStr == null)
            valueStr = "null";
        return valueStr;
    }

    private String _outputCollection(Object collection, Context ctx) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        String vname = "v" + ctx.index;
        if (collection instanceof List) {
            ctx.sb.append("java.util.ArrayList ").append(vname).append(" = new java.util.ArrayList();").append(ctx.br);
            List list = (List) collection;
            for (Object value : list) {
                if (value == null) {
                    ctx.sb.append(vname).append(".add(null);").append(ctx.br);
                    continue;
                }
                String valueStr = _valueStr(value, value.getClass(), ctx);;
                ctx.sb.append(vname).append(".add(").append(valueStr).append(");").append(ctx.br);
            }
        } else if (collection instanceof Set) {
            ctx.sb.append("java.util.HashSet ").append(vname).append(" = new java.util.HashSet();").append(ctx.br);
            Set set = (Set) collection;
            for (Object value : set) {
                if (value == null) {
                    ctx.sb.append(vname).append(".add(null);").append(ctx.br);
                    continue;
                }
                String valueStr = _valueStr(value, value.getClass(), ctx);;
                ctx.sb.append(vname).append(".add(").append(valueStr).append(");").append(ctx.br);
            }
        } else if (collection instanceof Map) {
            ctx.sb.append("java.util.HashMap ").append(vname).append(" = new java.util.HashMap();").append(ctx.br);
            Map map = (Map) collection;
            for (Object item : map.entrySet()) {
                Map.Entry entry = (Map.Entry) item;
                String valueStr = "null";
                String keyStr = "null";
                if (entry.getKey() != null) {
                    keyStr = _valueStr(entry.getKey(), entry.getKey().getClass(), ctx);
                }
                if (entry.getValue() != null) {
                    valueStr = _valueStr(entry.getValue(), entry.getValue().getClass(), ctx);
                }
                ctx.sb.append(vname).append(".put(").append(keyStr).append(", ").append(valueStr).append(");").append(ctx.br);
            }
        }
        return vname;
    }

    private boolean _isBean(Object value) throws SecurityException {
        if (value == null)
            return false;
        if (_isCollection(value))
            return false;
        Class type = value.getClass();
        try {
            type.getConstructor();
            return true;
        } catch (NoSuchMethodException e) {
            return false;
        }
    }

    private boolean _isCollection(Object value) {
        if (value == null)
            return false;
        Class type = value.getClass();
        return List.class.isAssignableFrom(type) || Set.class.isAssignableFrom(type) || Map.class.isAssignableFrom(type); 
    }

    // output simple value, returns null for non-singleliners
    private String _outputValue(Object value, Class type) {
        if (value == null)
            return null;
        Class vtype = value.getClass();
        if (type == long.class) {
            return value.toString() + "L";
        }
        if (type == float.class) {
            return value.toString() + "F";
        }
        if (type == short.class) {
            return "(short) " + value.toString() + "";
        }
        if (type.isPrimitive()) {
            return value.toString();
        }
        if (String.class.isAssignableFrom(type)) {
            return '"' + StringEscapeUtils.escapeJava(value.toString()) + '"';
        }
        if (Integer.class == type || Double.class == type || Boolean.class == type) {
            return type.getName() + ".valueOf(" + value.toString() + ")";
        }
        if (Long.class == type) {
            return type.getName() + ".valueOf(" + value.toString() + "L)";
        }
        if (Short.class == type) {
            return type.getName() + ".valueOf((short)" + value.toString() + ")";
        }
        if (Float.class == type) {
            return type.getName() + ".valueOf(" + value.toString() + "F)";
        }
        if (Date.class.isAssignableFrom(type)) {
            Date date = (Date) value;
            return "new java.util.Date(" + date.getTime() + "L)";
        }
        return null;
    }

}