public static Object deepCopy(Object src)
{
    int srcLength = Array.getLength(src);
    Class srcComponentType = src.getClass().getComponentType();

    Object dest = Array.newInstance(srcComponentType, srcLength);

    if (srcComponentType.isArray())
    {
        for (int i = 0; i < Array.getLength(src); i++)
            Array.set(dest, i, deepCopy(Array.get(src, i)));
    }
    else
    {
        System.arraycopy(src, 0, dest, 0, srcLength);
    }

    return dest;
}