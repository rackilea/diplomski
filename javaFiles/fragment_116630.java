import java.time.LocalDateTime;
import java.util.List;
import java.util.ArrayList;

public class StackOverflowTest {
  public static void main(String[] args){
    StackOverflowTest test = new StackOverflowTest();

/*
    Timeline. Numbers are in miliseconds:
    0000: Initial memory
    0100: Start threads                <-- no output of memory
    1100: Threads created
    2100: Threads allocate data        <-- no output of memory
    3100: Memory of allocated data
    4100: Threads release data         <-- no output of memory
    5100: Memory of deallocated data
    6100: Threads die                  <-- no output of memory
    7100: Threads are gone
*/

    try {
      printUsedMemoryAndGC("0000", "Initally");

      Thread.sleep(100);

      for (int i = 0; i < 1; i++) { // set to just one Thread
        new Thread(new RunnableTest()).start();
      }    

      Thread.sleep(1000);
      printUsedMemoryAndGC("1100", "Threads created");

      Thread.sleep(2000);
      printUsedMemoryAndGC("3100", "Memory of allocated data");

      Thread.sleep(2000);
      printUsedMemoryAndGC("5100", "Memory of deallocated data");

      Thread.sleep(2000);
      printUsedMemoryAndGC("7100", "Threads are gone");
    } catch (InterruptedException ex) {
      // we don't care about this
    }

  }

  public static void printUsedMemoryAndGC(String time, String message) {
    Runtime rt = Runtime.getRuntime();
    long total;
    long free;

    total = rt.totalMemory();
    free  = rt.freeMemory();
    System.out.printf("%-4s: %-30s %3$tH:%3$tM:%3$tS Used: %4$10s B\n",
                        time, message, LocalDateTime.now(), total-free);

    System.gc();

    total = rt.totalMemory();
    free  = rt.freeMemory();
    System.out.printf("%-4s: %-30s %3$tH:%3$tM:%3$tS Used: %4$10s B\n", 
                        time, "Garbage collection", LocalDateTime.now(), total-free);
  }

}


class RunnableTest implements Runnable{
  private ThreadLocal<List<Integer>> threadList1 =
            new ThreadLocal<List<Integer>>() {
              @Override
              protected List<Integer> initialValue() {
                return new ArrayList<Integer>();
              }
            };
  private ThreadLocal<List<Long>> threadList2 =
            new ThreadLocal<List<Long>>() {
              @Override
              protected List<Long> initialValue() {
                return new ArrayList<Long>();
              }
            };
  private ThreadLocal<List<Double>> threadList3 =
            new ThreadLocal<List<Double>>() {
              @Override
              protected List<Double> initialValue() {
                return new ArrayList<Double>();
              }
            };

  public void run(){
    try {
      Thread.sleep(2000);
      allocateData(1000000);
//      allocateData(30000000); // This is too much for my system.

      Thread.sleep(2000);
      clearData();

      Thread.sleep(2000); // don't just stop yet.
    } catch (InterruptedException ex) {
      // we don't care about this
    }
  }

  public void allocateData(int max) {
    List<Integer> list1 = threadList1.get();
    List<Long>    list2 = threadList2.get();
    List<Double>  list3 = threadList3.get();
    for (int i = 0; i < max; i++) {
      list1.add(Integer.valueOf(i));
      list2.add(Long.valueOf(i));
      list3.add(Double.valueOf(i));
    }
  }

  public void clearData() {
//    threadList1 = null;                         // No effect.
//    threadList2 = null;
//    threadList3 = null;
    threadList1.set(new ArrayList<Integer>());  // resetting the value
    threadList2.set(new ArrayList<Long>());
    threadList3.set(new ArrayList<Double>());
//    threadList1.remove();                       // removing the value
//    threadList2.remove();
//    threadList3.remove();

  }
}