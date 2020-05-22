CountDownLatch latch = new CountDownLatch(1); //here 1 indicates that only one thread is present

public class TestThread {
  public static void main(String args[]) throws InterruptedException {
  ReadFile readFile = new ReadBatchReReadFile();
  Thread readBatchRecordThread = new Thread(readFile);
  readBatchRecordThread.start();
  latch.await(); //here await method will work for you.
  List<Integer> list = readFile.getTenRecordList();
}