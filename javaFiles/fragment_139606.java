public class MyWorker extends SwingWorker<Integer, String> {

  @Override
  protected Integer doInBackground() throws Exception {
    // Start
    publish("Start Download");
    setProgress(1);

    // More work was done
    publish("More work was done");
    setProgress(10);

    // Complete
    publish("Complete");
    setProgress(100);
    return 1;
  }

  @Override
  protected void process(List< String> chunks) {
    // Messages received from the doInBackground() (when invoking the publish() method)
  }
}