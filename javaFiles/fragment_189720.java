List<Set<Integer>> sets = new ArrayList<>();
addSets(sets, arr1, arr2, arr3);

// Time: O(n * k) where n=number of arrays and k=size of largest array
private static void addSets(List<Set<Integer>> sets, int [] ... arrs)
{
    for (int [] arr : arrs)
    {
        Set<Integer> s = new HashSet<>();
        for (int i : arr)
        {
            s.add(i);
        }
        sets.add(s);
    }
}