class C {
    public static void timer(int arraySize, C object) {
        long startTime = System.nanoTime();
        C myObject = object;
        System.out.println(Arrays.toString(myObject.getArray()));
        long endTime = System.nanoTime();
        System.out.print("Total time: " + (endTime - startTime) / 1000 + " microseconds");
    }
}