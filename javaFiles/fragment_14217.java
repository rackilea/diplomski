public static void replace(List<String> strings)
{
    ListIterator<String> iterator = strings.listIterator();
    while (iterator.hasNext())
    {
        iterator.set(iterator.next().toLowerCase());
    }
}