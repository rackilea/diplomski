class PrintNumbers implements IoOperation<Integer> {
    public void accept(Integer i) {
        System.out.println(i);
    }
    @Override
    public void commit() {
        System.out.println("done.");
    }
}
processAllAtems(IntStream.range(0, 100).parallel().boxed(), new PrintNumbers());