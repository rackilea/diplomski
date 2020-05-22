public class MyService extends Service {

  @Override
  public int onStartCommand(Intent intent, int flags, int startId) {
          // This is where you would place your code that you want in the background
          // Putting your while loop here will make sure it runs when the app is closed
          return Service.START_STICKY;
  }

  @Override
  public IBinder onBind(Intent intent) {
        //TODO for communication return IBinder implementation
    return null;
  }
}