int[] array = new int[9];
// fill array
Set<Integer> set = new HashSet<Integer>();
for (int i : array)
    set.add(i);
boolean allDistinct = set.size() == 9;