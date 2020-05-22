public class FlowStream {

@Test
public void flowStream() {
    int items = 10;

    print("\nflow");
    Flowable.range(0, items)
            .map(this::expensiveCall)
            .map(this::expensiveCall)
            .forEach(i -> print("flowed %d", i));

    print("\nparallel flow");
    Flowable.range(0, items)
            .flatMap(v ->
                    Flowable.just(v)
                            .subscribeOn(Schedulers.computation())
                            .map(this::expensiveCall)
            )
            .flatMap(v ->
                    Flowable.just(v)
                            .subscribeOn(Schedulers.computation())
                            .map(this::expensiveCall)
            ).forEach(i -> print("flowed parallel %d", i));

    await(5000);

}

private Integer expensiveCall(Integer i) {
    print("making %d more expensive", i);
    await(Math.round(10f / (Math.abs(i) + 1)) * 50);
    return i;
}

private void await(int i) {
    try {
        Thread.sleep(i);
    } catch (InterruptedException e) {
        throw new RuntimeException(e);
    }
}

private void print(String pattern, Object... values) {
    System.out.println(String.format(pattern, values));
}

}