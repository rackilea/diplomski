public static void main(String[] args) {


    List<Integer> elements = Arrays.asList(1, 2, 3, 5, 8, 13);
    ExecutorService executor = Executors.newSingleThreadExecutor();

    List<Future<Integer>> results = elements.stream().map((e) -> {

        return executor.submit(() -> {
            // Fail for even numbers
            if (e % 2 == 0) {
                throw new RuntimeException();
            }

            return e;
        });

    }).collect(Collectors.toList());

    results.forEach((e) -> {
        try {
            System.out.println(e.get());
        } catch (InterruptedException | ExecutionException e1) {
            System.out.println(false);
        }
    });
}