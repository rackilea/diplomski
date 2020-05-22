Integer[][] A = IntStream.range(0, n)
    .mapToObj(i -> IntStream.range(0, m)
        .mapToObj(j -> Functions.INSTANCE.A.apply(i, j))
        .toArray(Integer[]::new))
    .toArray(Integer[][]::new);

String[][] B = IntStream.range(0, n)
    .mapToObj(i -> IntStream.range(0, m)
        .mapToObj(j -> Functions.INSTANCE.B.apply(i, j))
        .toArray(String[]::new))
    .toArray(String[][]::new);