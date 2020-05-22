public class SendTPS extends TimerTask {

  public static void main(String[] args){

    int maxTPS = 15;

    Timer timer = new Timer();
    int maxSleepInterval = Math.round((1000 / maxTPS));

    timer.schedule(new SendTPS(), 0, maxSleepInterval);
  }

  public static  void fetchData(){
    System.out.println(new SimpleDateFormat("HH:mm:ss").format(new 
    java.util.Date())+"fetch data....");
  }

  public void run() {
    fetchData();
  }
}