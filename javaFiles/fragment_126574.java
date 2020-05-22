public class IntentServiceDemo extends IntentService {
          int currentState=0;

      public IntentServiceDemo() {
        super("IntentServiceDemoWorker");  // super the name of worker thread, it is necessary.
    }
    @Override
     protected void onHandleIntent(Intent intent) {
                while (true) {
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                       ++currentState:
                    Log.d("vabhi", "currentState : " + currentState);
                }  // End of while
    }
}