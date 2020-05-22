public static void main(String[] args) {
    List<Integer> list = IntStream.range(0, 280).boxed().collect(toList());
    AtomicInteger count = new AtomicInteger();
    StreamSupport.stream(list.spliterator(), false)
            .collect(groupingBy(e -> count.getAndIncrement() / 50, 
                 collectingAndThen(toList(), l -> {
                                 processBatch(l);
                                 return null;
                  })));
}

public static <T extends Object> void processBatch(List<T> list) {
    System.out.println(list.size());
}