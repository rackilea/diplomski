public Method getMethod(Class<?> targetClass, Class<?> proxyClass, final String name) throws ReflectiveOperationException, NoSuchMethodException
{
    Method meth = null;

    for (Method m : targetClass.getMethods())
    {
        String alias;
        WorkflowMethod annotation = m.getAnnotation(WorkflowMethod.class);
        if (annotation == null)
        {
            log.warn("...);
            continue;
        }

        alias = annotation.alias();
        if (StringUtils.isEmpty(alias))
            alias = m.getName();
        if (!name.equals(alias))
            continue;

        if (meth != null)
            throw new Exception(...);
        if (proxyClass == null)
            meth = m;
        else
            meth = proxyClass.getMethod(m.getName(), m.getParameterTypes());
    }

    if (meth == null)
        throw new NoSuchMethodException(...);
    return meth;
}