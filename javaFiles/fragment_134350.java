class IORunner extends Thread {
  IORunner(InputStream in, BlockingQueue outputQueue) {
    this.reader = new BufferedReader(new InputStreamReader(in, "utf-8"));
    this.outputQueue = outputQueue;
  }

  public void run() {
    String line;
    while((line=reader.readLine())!=null)
      this.outputQueue.put(line);
  }
}

class Main {
  public static void main(String args[]) {
    ...
    BlockingQueue dataQueue = new LinkedBlockingQueue();
    new IORunner(myStreamFromSomewhere, dataQueue).start();

    while(true) {
      if(!dataQueue.isEmpty()) { // can also use .peek() != null
        System.out.println(dataQueue.take());
      }
      Thread.sleep(1000);
    }
  }
}