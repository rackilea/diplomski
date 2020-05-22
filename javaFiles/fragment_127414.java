Stream.generate(() -> {
        try {
            return queue.take();
        } catch (InterruptedException ie) {
            return "Interrupted!";
        }
    })
    .filter(s -> s.endsWith("x"))
    .forEach(System.out::println);