public boolean testBoard(int[][] board) {
    List<Callable<Boolean>> tests = new ArrayList<>();
    tests.add(() -> Boolean.valueOf(testCols(board));
    tests.add(() -> Boolean.valueOf(testRegions(board));
    tests.add(() -> Boolean.valueOf(testRows(board));
    tests.add(() -> Boolean.valueOf(testSize(board));

    /*Maybe store this threadPool in a field so you dont create it everytime*/
    ExecutorService threadPool = Executors.newCachedThreadPool();
    List<Future<Boolean>> results = threadPool.invokeAll(tests);

    for(Future<Boolean> future: results){
       if(!Boolean.TRUE.equals(future.get()){
          return false;
       }
    }
    return true;
}