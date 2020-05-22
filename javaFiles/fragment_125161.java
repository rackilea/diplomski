// the parameter contains the (1,m1), (1,m2), (3,m3) pairs
private static Map<Double,Runnable> splitToPercentageMap(Collection<Pair<Integer,Runnable>> runnables)
{

    // this adds all Runnables to lists of same int value,
    // overall those lists are sorted by that int (so least probable first)
    double total = 0;
    Map<Integer,List<Runnable>> byNumber = new TreeMap<>();
    for (Pair<Integer,Runnable> e : runnables)
    {
        total += e.first;
        List<Runnable> list = byNumber.getOrDefault(e.first, new ArrayList<>());
        list.add(e.second);
        byNumber.put(e.first, list);
    }

    Map<Double,Runnable> targetList = new TreeMap<>();
    double current = 0;
    for (Map.Entry<Integer,List<Runnable>> e : byNumber.entrySet())
    {
        for (Runnable r : e.getValue())
        {
            double percentage = (double) e.getKey() / total;
            current += percentage;
            targetList.put(current, r);
        }
    }

    return targetList;
}