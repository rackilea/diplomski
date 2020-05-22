public Set findRarest()
{
    Set<String> rarest = new HashSet<String>();

    int occurrence = Integer.MAX_VALUE;  //high initial value for word length
    for (Map.Entry<String,Integer> item : wcMap.entrySet())
    {
        if (item.getValue() == occurrence)
        {
            rarest.add(item.getKey());
        }
        else if ( item.getValue() < occurrence )
        {
            occurrence = item.getValue();
            rarest.clear();
            rarest.add(item.getKey());
        }
    }
    return rarest;
}