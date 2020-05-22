int total = 9;
Integer[] S = {1, 4, 7, 2, 3, 4, 6};
Set<Integer> set = new HashSet<Integer>(Arrays.asList(S));
for (int i : set)
    if (set.contains(total - i))
        System.out.println(i + " + " + (total - i) + " = " + total);