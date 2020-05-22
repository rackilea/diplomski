public static void main(String[] args) {
    List<Integer> inputs = Arrays.asList(0, 1, 2, 3, 4, 5);
    CompletableFuture<Integer> matching = findMatch(inputs);

    System.out.println("Found match: " + matching.join());
}