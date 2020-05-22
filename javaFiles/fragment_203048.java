private static final RequestProcessor rp = new RequestProcessor(MyClass.class);
private RequestProcessor.Task task = rp.create(new Runnable() {
  public void run() {
    //...do some expensive parsing or similar
  }
});

public void keyPressed (KeyEvent ke) {
  task.schedule(200); // (re)schedule the task 200ms in the future;  if schedule() is called again, it will be postponed
}