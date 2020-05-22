Integer longCalculation(Integer x) {
    try {
        Thread.sleep(1000);
    } catch (InterruptedException ignored) {
    }
    return x * 2;
}
Function<Integer, Integer> f = this::longCalculation;
Function<Integer, Integer> g = Memoizer.memoize(f);

public void automaticMemoizationExample() {
    long startTime = System.currentTimeMillis();
    Integer result1 = g.apply(1);
    long time1 = System.currentTimeMillis() - startTime;
    startTime = System.currentTimeMillis();
    Integer result2 = g.apply(1);
    long time2 = System.currentTimeMillis() - startTime;
    System.out.println(result1);
    System.out.println(result2);
    System.out.println(time1);
    System.out.println(time2);
}