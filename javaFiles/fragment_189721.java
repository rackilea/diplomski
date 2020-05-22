List<String> pairs = findClusters(sets, m);

// Time: O(n^2 * k) where n=number of arrays and k=size of largest array
private static List<String> findClusters(List<Set<Integer>> sets, int m)
{
    // holds the pairs
    List<String> pairs = new ArrayList<>();

    for (int i = 0; i < sets.size() - 1; i++)
    {
        Set<Integer> primary = sets.get(i);

        for (int j = i + 1; j < sets.size(); j++)
        {
            Set<Integer> secondary = sets.get(j);

            for (int p : primary)
            {
                if (secondary.contains(p - m))
                {
                    pairs.add(p + ", " + (p-m));
                }
                if (secondary.contains(p + m))
                {
                    pairs.add(p + ", " + (p+m));
                }
            }
        }
    }
    return pairs;
}