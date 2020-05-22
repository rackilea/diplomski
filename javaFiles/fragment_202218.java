public static void main(String[] args) {

        Arrays.asList(1, 5, 10, 50, 100, 500, 1000).forEach(
                size -> {
                    System.out.println("Size: " + size);
                    Integer[][] numOfVertices = createArray(size);

                    Map<String, Runnable> toRun = Map.of(
                            "For loop:",
                            () -> {
                                for (int i = 0; i < size; i++) {
                                    for (int j = 0; j < size; j++) {
                                        doSomething(numOfVertices[i][j]);
                                    }
                                }
                            },
                            "IntStream.range:",
                            () -> {
                                IntStream.range(0, size)
                                        .forEach(i -> (IntStream.range(0, size))
                                                .forEach(j -> {
                                                    doSomething(numOfVertices[i][j]);
                                                }));
                            },
                            "IntStream.range parallel:",
                            () -> {
                                IntStream.range(0, size).parallel()
                                        .forEach(i -> (IntStream.range(0, size))
                                                .forEach(j -> {
                                                    doSomething(numOfVertices[i][j]);
                                                }));
                            }
                    );

                    int howManyTimes = 10000;
                    Map<String, Double> map = new HashMap<>();
                    toRun.entrySet().forEach(e -> {
                        double time = (((double)IntStream.range(0, howManyTimes).mapToObj(
                                (x) -> executionTime(e.getValue()))
                                .reduce(Long::sum).get()) / howManyTimes);

                        map.put(e.getKey(), time);
                    });

                    map.entrySet().forEach(e -> {
                        System.out.println(String.format("%25s %f", e.getKey(), e.getValue()));
                    });
                }
        );
    }

    private static Integer[][] createArray(int size) {
        Integer[][] val = new Integer[size][size];
        IntStream.range(0, size).forEach(
                i -> IntStream.range(0,size).forEach(
                        j -> val[i][j] = (int)(Math.random() * 100)
                )
        );
        return  val;
    }

    private static int doSomething(int val) {
        return val * val;
    }

    private static long executionTime(Runnable execThis)
    {
        long startTime = System.currentTimeMillis();
        execThis.run();
        long endTime = System.currentTimeMillis();
        return (endTime-startTime);
    }