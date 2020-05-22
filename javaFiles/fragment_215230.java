public class ReadTask extends Thread {
  private byte[] mResultBuffer;
  private Exception mCaught;
  private Thread mWatcher;
  public ReadTask(Thread watcher) {
    mWatcher = watcher;
  }

  public void run() {
    try {
      mResultBuffer = sendAndReceive();
    } catch (Exception e) {
      mCaught = e;
    }
    mWatcher.interrupt();
  }
  public Exception getCaughtException() {
    return mCaught;
  }
  public byte[] getResults() {
    return mResultBuffer;
  }
}

public byte[] wrappedSendAndReceive() {
  byte[] data = new byte[1024];
  ReadTask worker = new ReadTask(data, Thread.currentThread());

  try {
    worker.start();
    Thread.sleep(6000);
  } catch (InterruptedException e) {
    // either the read completed, or we were interrupted for another reason
    if (worker.getCaughtException() != null) {
      throw worker.getCaughtException();
    }
  }

  // try to interrupt the reader
  worker.interrupt();
  return worker.getResults;
}