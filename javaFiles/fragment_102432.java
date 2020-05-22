int[] x = {0,1,2,3};
    // int to double
    double[] doublesArray = Arrays.stream(x).asDoubleStream().toArray();
    //int to string
    String[] stringArray = Arrays.stream(x).mapToObj(String::valueOf).toArray(String[]::new);
    // string to double
    double[] doublesArrayFromString = Arrays.stream(stringArray).mapToDouble(Double::valueOf).toArray();

    Arrays.stream(doublesArray).forEach(System.out::println);
    Arrays.stream(stringArray).forEach(System.out::println);
    Arrays.stream(doublesArrayFromString).forEach(System.out::println);