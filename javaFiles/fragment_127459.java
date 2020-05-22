public static boolean contains (Object element, Collection <?> ... collections)
{
    for (Collection c: collections)
        if (c.contains (element)) return true;

    return false;
}