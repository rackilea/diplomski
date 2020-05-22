cf.thenApplyAsync(i -> {
    try {
        System.out.println("F");
        Thread.sleep(5000);
        return i;
    } catch(InterruptedException e) {
        throw new RuntimeException(e);
    }
}).thenApplyAsync(i -> {
        System.out.println("G");
        return i;
});

cf.thenApplyAsync(i -> {
        System.out.println("H");
        return i;
});