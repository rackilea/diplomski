private static void findTwoRepeatingElements(Integer[] array) {

    Set<Integer> seen = new HashSet<Integer>();
    Set<Integer> repeated = new HashSet<Integer>();

    for (Integer i : array)
        if (!seen.add(i) && repeated.add(i))
            System.out.println(i);

}