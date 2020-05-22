public static List<String> flat(Object o)
{
    List<String> strings = new ArrayList<String>();
    if (o.getClass().isArray())
    {
        Object[] oarr = (Object[]) o;
        for (Object obj : oarr)
        {
            strings.addAll(flat(obj));
        }
    }
    else
    {
        strings.add(o.toString());
    }
    return strings;
}