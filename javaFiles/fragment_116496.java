public String getDataType(Class clazz)
{
    if(clazz.isPrimitive())
        return clazz.getName();

    if(clazz.isArray())
        return getDataType(clazz.getComponentType()) + "[]";

    String typeName;
    if("java.lang".equals(clazz.getPackage().getName()))
        typeName = clazz.getName().substring(10);
    else
        typeName = clazz.getName();

    return typeName;
}

public String getDataType(Type type)
{
    if(type instanceof Class)
        return getDataType((Class)type);

    if(type instanceof ParameterizedType)
    {
        ParameterizedType pt = (ParameterizedType)type;
        StringBuilder typeName = new StringBuilder(getDataType(pt.getRawType()));

        Type[] specificTypes = pt.getActualTypeArguments();
        if(null != specificTypes && 0 < specificTypes.length)
        {
            typeName.append("<");
            for(int j=0; j<specificTypes.length; ++j)
            {
                if(j > 0)
                    typeName.append(",");

                typeName.append(getDataType(specificTypes[j]));
            }

            typeName.append(">");
        }

        return typeName.toString();
    }

    return "[" + type + ", a " + type.getClass().getName() + "]";
}

public void getMethodSignature(Method m)
{
    System.out.print(getDataType(m.getGenericReturnType());
    System.out.print(" ");
    System.out.print(method.getName());
    System.out.print("(");
    Type[] parameterTypes = method.getGenericParameterTypes();
    if(null != parameterTypes && 0 < parameterTypes.length)
    {
        for(int i=0; i<parameterTypes.length; ++i)
        {
            if(0<i) System.out.print(",");
            System.out.print(getDataType(parameterTypes[i]));
        }
    }
    System.out.println(")");
}