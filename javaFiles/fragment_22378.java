public class SharedDataTest {

  private static class SomeWork implements Runnable {
    private Map<String, String> dataTable;

    public SomeWork(Map<String, String> dataTable) {
      this.dataTable = dataTable;
    }

    @Override
    public void run() {
      //do some stuff with dataTable
    }
  }

  public static void main(String[] args) {

    Map<String, String> dataTable = new ConcurrentHashMap<String, String>();

    Runnable work1 = new SomeWork(dataTable);
    Runnable work2 = new SomeWork(dataTable);

    new Thread(work1).start();
    new Thread(work2).start();

  }

}