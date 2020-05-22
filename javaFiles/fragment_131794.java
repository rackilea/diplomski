try {
    //...
} catch (OutOfMemoryError er) {
    // this will tell you how much you have used
    long heapSize = Runtime.getRuntime().totalMemory();
    System.err.println("memory used "+heapSize);
}