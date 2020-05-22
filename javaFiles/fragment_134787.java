for (int i0 = 1; i0 < x; i0++) {
    final int i = i0; // tmp store as final for use in lambda
    ResultContainer result = IntStream.range(0, y).parallel()
            .collect(() -> new ResultContainer(y), (resultContainer, j) -> {
                double a1 = a[i - 1][j];
                double a2 = a[i][j];
                double a3 = a1 * a2;
                double cij = c[i - 1][j] + a3;
                resultContainer.add(-a3, cij * a3, j, cij);
            }, ResultContainer::add);

    d += result.d;
    e[i] = d + result.f;
    c[i] = result.ci;
    a[i] = IntStream.range(0, y).parallel().mapToDouble(j -> e[i] * b[i][j]).toArray();
}