public static boolean isEmpty(Collection coll)
{
    return ((coll == null) || (coll.isEmpty()));
}

public static boolean isNotEmpty(Collection coll)
{
    return (!(isEmpty(coll)));
}