public static void main(String[] args) {
    m1().filter(e -> {
        System.out.println(e);
        return false;
    }).findFirst();
}

private static LongStream m1() {
    return StreamSupport.longStream(Arrays.spliterator(new long[] { 1, 2, 3, 4 }), false);
}