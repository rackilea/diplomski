try {
    List<Callable<Object>> callableList = new ArrayList<Callable<Object>>();
    callableList.add(null); /*Add instance of Callable*/
    callableList.add(null); /*Add instance of Callable*/
    callableList.add(null); /*Add instance of Callable*/

    //Specify how many threads you want or need to operate. Read other methods of Executors which return different instances of ExecutorService
    final ExecutorService service = Executors.newFixedThreadPool(3);

    //This will invoke all your N tasks in specified M threads ...
    List<Future<String[]>> futureObjects = service.invokeAll(callableList);  //futureObjects will contain result of each thread execution
} catch (InterruptedException e) {
    e.printStackTrace();
}