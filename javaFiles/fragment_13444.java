int[] ints = Arrays.stream(str.split(" +"))
    .mapToInt(Integer::parseInt)
    .sorted()
    .toArray();

System.out.println(Arrays.toString(ints));