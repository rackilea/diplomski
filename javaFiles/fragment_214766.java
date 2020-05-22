Integer numberArray[] = { 1, 2, 45, 6, 7, 7, 8, 9, 10, 11, 10, 9, 1 };
    Set<Integer> printed = new HashSet<>();
    Map<Integer, Integer> map = new HashMap<Integer, Integer>();
    for (Integer s : Arrays.asList(numberArray)) {
        if (printed.add(s)) // Set.add() also tells if the element was in
                            // the Set!
            System.out
                    .println("element: " + s + ", count: " + Collections.frequency(Arrays.asList(numberArray), s));

        if (Collections.frequency(Arrays.asList(numberArray), s) > 1) {
            map.put(s, Collections.frequency(Arrays.asList(numberArray), s));
        }
    }
    Integer sum = 0;
    for (Map.Entry m : map.entrySet()) {
        System.out.println(m.getKey() + " " + m.getValue());
        sum = sum + ((Integer) m.getKey() * (Integer) m.getValue());
    }
    System.out.println("sum is" + sum);