executorService.submit(() -> {
    System.out.println("Starting");
    int n = new Random().nextInt(4000);
    // try-catch-finally omitted
    return n;                                      // <-- HERE IT RETURNS N
});