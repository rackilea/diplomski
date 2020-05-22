Random r = new Random();
    List<Integer> numbers = new ArrayList<>(Arrays.asList(new Integer[] {
            1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12 }));

    Integer[] colOne = new Integer[] { 6, 5, 3 };
    numbers.removeAll(Arrays.asList(colOne));

    int notFoundInColOne = numbers.get(r.nextInt(numbers.size()));