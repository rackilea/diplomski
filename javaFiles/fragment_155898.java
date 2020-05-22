ExecutorService executor = Executors.newFixedThreadPool(5);

MoveMessages moveMessages = new MoveMessages();
Future<Boolean> submit = executor.submit(moveMessages);

Boolean integer = submit.get(); // Will wait until task is finished

executor.shutdown();