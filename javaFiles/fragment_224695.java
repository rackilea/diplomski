List<Tuple> reduce = tupleStream.collect(ArrayList::new, WDParser::add, WDParser::combine);

private static List<Tuple> combine(List<Tuple> list1, List<Tuple> list2)
{
    if (!list2.isEmpty())
    {
        add(list1, list2.remove(0)); // merge lists in the middle if necessary
        list1.addAll(list2);         // add all the rest
    }
    return list1;
}

private static List<Tuple> add(List<Tuple> list, Tuple t)
{
    int lastIndex = list.size() - 1;
    if (list.isEmpty() || list.get(lastIndex).getDirection() != t.getDirection())
    {
        list.add(t);
    }
    else
    {
        list.set(lastIndex, list.get(lastIndex).merge(t));
    }
    return list;
}