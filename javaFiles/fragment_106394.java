public void testForLoopCreateInt(long numberOfIterations) {
    ArrayList<Integer> listOfIntegers = new ArrayList<Integer>();
    long startTime = 0;
    long endTime = 0;
    long totalTime = 0;
    System.out.println("\n===========================" + "\ntestForLoopCreateInt() Looping for: " + numberOfIterations);
    startTime = System.currentTimeMillis();
    for(long counter = 0; counter < numberOfIterations; counter++) {
        int i = 0;
        listOfIntegers.add(i);
    }
    endTime = System.currentTimeMillis();
    totalTime = endTime - startTime;
    System.out.println("Total time: " + totalTime + " milliseconds");

    System.out.println("===========================testForLoopCreateInt()");

    for (int indexer = 0; indexer < 10; indexer++) {
        int y = listOfIntegers.get(indexer);
    }
}