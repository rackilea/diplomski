public class MyExtensionContext extends FREContext {    
    public Activity act;        

    public void doThreadWork() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                // Do stuff with Activity "act" here
            }
        }
    }
}