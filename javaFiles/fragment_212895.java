public int compare(String a, String b)
{
    Integer aVal = tiedMap.get(a);
    Integer bVal = tiedMap.get(b);

    if (aVal > bVal)
    {
        return 1; // or -1 for descending order
    }
    else if (aVal < bVal)
    {
        return -1; // or 1 for descending order
    }
    else
    {
        // if values are equivalent compare on key as well
        return a.compareTo(b);
        // or for descending order:
        // return b.compareTo(a);
    }
}