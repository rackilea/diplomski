Map<Integer, Set<Integer>> numbers = new TreeMap<>();
            int min = 10;
    int max = 20;
    Map<Integer, Set<Integer>> numbers = new TreeMap<>();
    for (int i = min; i <= max; i++) {
        Set<Integer> factors = new TreeSet<>();
        for (int j = 2; j <= i/2; j++) {
            if (i % j == 0) {
                factors.add(j);
            }
        }
        //factors.add(i);
        numbers.put(i, factors);

    }
    System.out.println(numbers.get(11).size());
    System.out.println(numbers.values());