private final ExecutorService executorService = Executors.newSingleThreadExecutor();

executorService.execute(new Runnable() {
 public void run() {
   fetch(Integer.parseInt(threadsNumField.getText()));
 }
});