public class TestThread {
public static void main(String args[]) throws InterruptedException {
  ReadFile readFile = new ReadBatchReReadFile();
  Thread readBatchRecordThread = new Thread(readFile);
  readBatchRecordThread.start();
  readBatchRecordThread.join(); //here join method will work for you.
  List<Integer> list = readFile.getTenRecordList();
}