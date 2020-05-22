@Test
public void testDoWithSession2() throws Exception {
    Function<String, Mono<Integer>> fun1 = str -> Mono.fromCallable(() -> {
        System.out.println("start some long timed work");
        //for demonstration we'll print some clock ticks
        for (int i = 1; i <= 5; i++) {
            try {
                Thread.sleep(1000);
                System.out.println(i + "s...");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("work has completed");
        return str.length();
    });

    //let two ticks show up
    StepVerifier.create(doWithConnection(fun1,2100))
                .verifyError(TimeoutException.class);
}