public static void main(String[] args) {
    m1().filter(e -> {
        System.out.println(e);
        return e%2 == 0;
    })
    .findFirst()
    .ifPresent(result -> System.out.println("final result: "+result));
}

private static LongStream m1() {
    // note that you can have it much simpler:
    return LongStream.of(1, 2, 3, 4 ).parallel();
}