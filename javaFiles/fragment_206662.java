public class ApacheLogFileTailer {
    public static void main(String[] args) {

    String filelog1 = "C:\\Users\\eventfile1.log";
    String filelog2 = "C:\\Users\\eventfile2.log";

    ApacheLogFileTailerListener listener = new ApacheLogFileTailerListener();

    Tailer tailer1 = new Tailer(new File(filelog1), listener, 50);
    Thread tailerThread1 =new Thread(tailer1);
    tailerThread1.setName("eventfile1.log");
    tailerThread1.start();

    Tailer tailer2 = new Tailer(new File(filelog2), listener, 50);
    Thread tailerThread2 =new Thread(tailer2);
    tailerThread1.setName("eventfile2.log");
    tailerThread2.start();

    }
    }

   public class ApacheLogFileTailerListener extends TailerListenerAdapter {

   @Override
   public void handle(String line) {
    // How to get the name of the file changed ?? 
    System.out.println("Log file change "+line);
    System.out.println("Log file change name "+Thread.currentThread().getName());
    super.handle(line);
   }

}