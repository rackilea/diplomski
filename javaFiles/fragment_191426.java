class C {
    public void timer(int arraySize) {
        long startTime = System.nanoTime();
        System.out.println(Arrays.toString(this.getArray()));
        long endTime = System.nanoTime();
        System.out.print("Total time: " + (endTime - startTime) / 1000 + " microseconds");
    }
}