private static void findTwoRepeatingElements(Integer[] array) {
    Set<Integer> seen = new HashSet<Integer>();
    for (Integer i : array) {
        if (seen.contains(i))
            System.out.println(i);
        else
            seen.add(i);
    }
}