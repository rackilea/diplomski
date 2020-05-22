Long start = 0L;
    List<Long> list = new ArrayList<>();
    for (int i = 0; i < 1_000; ++i) {
        start = System.nanoTime();
        // your method to be tested;
        list.add(System.nanoTime() - start);
    }
    System.out.println("Time cost summary: " + list.stream().collect(Collectors.summarizingLong(Long::valueOf)));