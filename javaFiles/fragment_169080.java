package me.wener.practices.web.common.util;

import com.google.common.collect.Lists;
import java.lang.reflect.Field;
import java.util.List;
import javax.persistence.metamodel.Attribute;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.reflect.FieldUtils;

@Slf4j
public class BeanHelper
{
    /**
     * 获取 bean 的属性,如果属性不存在或发生异常返回null
     */
    public static Object tryGetProperty(Object bean, String attrName)
    {
        Object property = null;
        try
        {
            Field field = FieldUtils.getField(bean.getClass(), attrName, true);
            property = field.get(bean);
        } catch (Exception e)
        {
            if (log.isErrorEnabled())
                log.error("Exception when get property " + attrName + " on " + bean, e);
        }
        return property;
    }

    public static <T, A extends Attribute<T, ?>> Object tryGetProperty(T bean, A attr)
    {
        return tryGetProperty(bean, attr.getName());
    }

    public static <T, A extends Attribute<T, ?>> boolean trySetProperty(T bean, A attr, Object value)
    {
        return trySetProperty(bean, attr.getName(), value);
    }

    public static boolean trySetProperty(Object bean, String attrName, Object value)
    {
        boolean failed = false;
        try
        {
            // 对于 chain 的 setter 方法, 必须要使用 force access.
            Field field = FieldUtils.getField(bean.getClass(), attrName, true);
            field.set(bean, value);
        } catch (Exception e)
        {
            if (log.isErrorEnabled())
                log.error("Exception when set property " + attrName + " on " + bean, e);

            failed = true;
        }
        return !failed;
    }

    /**
     * Test the value of search in attrs is make the isNull and isEmpty
     * <p/>
     * isEmpty will apply when value is String
     */
    @SafeVarargs
    public static <E, A extends Attribute<E, ?>> List<A> skip(Object searcher, boolean skipNull, boolean skipEmpty, A... attrs)
    {
        return skip(searcher, skipNull, skipEmpty, Lists.newArrayList(attrs));
    }

    public static <E, A extends Attribute<E, ?>> List<A> skip(Object searcher, boolean skipNull, boolean skipEmpty, List<A> attrs)
    {
        List<A> list = Lists.newArrayList();
        boolean valid;

        for (A attr : attrs)
        {
            Object value = tryGetProperty(searcher, attr.getName());
            valid = skipNull || value != null;

            if (valid && skipEmpty && value instanceof String)
                valid = ((String) value).length() != 0;

            if (valid)
                list.add(attr);
        }
        return list;
    }

    @SafeVarargs
    public static <E, A extends Attribute<E, ?>> List<A> skipNullOrEmpty(Object searcher, A... attrs)
    {
        return skip(searcher, true, true, attrs);
    }

    public static <E, A extends Attribute<E, ?>> List<A> skipNullOrEmpty(Object searcher, List<A> attrs)
    {
        return skip(searcher, true, true, attrs);
    }

    @SafeVarargs
    public static <T, A extends Attribute<T, ?>> T merge(T target, T src, A... attrs)
    {
        return merge(target, src, Lists.newArrayList(attrs));
    }

    public static <T, A extends Attribute<T, ?>> T merge(T target, T src, List<A> attrs)
    {
        for (A attr : attrs)
        {
            String attrName = attr.getName();
            Object value = tryGetProperty(src, attrName);
            trySetProperty(target, attrName, value);
        }

        return target;
    }
}