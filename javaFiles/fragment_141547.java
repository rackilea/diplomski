Map<Integer, Double[]> foo = new HashMap<Integer, Double[]>();
double[] bar = new double[10];
//As you can see, 1 is passed directly and will be converted to Integer object.
foo.put(1, Arrays.stream(bar)
            .boxed()
            .toArray(Double[]::new));