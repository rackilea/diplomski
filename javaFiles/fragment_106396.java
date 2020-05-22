public void testForLoopCreateUniformStringAndStoreToArrayList(long numberOfIterations) {
    ArrayList<String> listOfIntegers = new ArrayList<String>();
    long startTime = 0;
    long endTime = 0;
    long totalTime = 0;
    System.out.println("\n===========================" + "\ntestForLoopCreateUniformStringAndStoreToArrayList() Looping for: " + numberOfIterations);
    startTime = System.currentTimeMillis();
    for(long counter = 0; counter < numberOfIterations; counter++) {
        String string = new String("01234");
        listOfIntegers.add(string);
    }
    endTime = System.currentTimeMillis();
    totalTime = endTime - startTime;
    System.out.println("Total time: " + totalTime + " milliseconds");

    System.out.println("===========================testForLoopCreateUniformStringAndStoreToArrayList()");

    for (int indexer = 0; indexer < 10; indexer++) {
        String y = listOfIntegers.get(indexer);
    }
}