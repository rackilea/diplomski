public class WorkerThread extends Observable implements Runnable {
public void run() {
    try {
            DoSomething();
            String response = "Doing something";
            setChanged();
            notifyObservers( response );
            DoSomethingElse();
            String response = "Doing something else";
            setChanged();
            notifyObservers( response );
    }
    catch (IOException e) {
        e.printStackTrace();
    }
}
private void DoSomething(){
}
private void DoSomethingElse(){
}


public class MainActivity{
public class ResponseHandler implements Observer {
    private String resp;
    public void update (Observable obj, Object arg) {
        if (arg instanceof String) {
            resp = (String) arg;
            //Write message to UI here ie System.out.println("\nReceived Response: "+ resp );
            //or EditText et = (EditText)findViewById(R.id.blah);
            // blah.SetText(resp);
        }
    }
}
private void doStuffAndReportToUI(){
    final WorkerThread wt = new WorkerThread();
    final ResponseHandler respHandler = new ResponseHandler();
    wt.addObserver( respHandler );
    Thread thread = new Thread(wt);
    thread.start();
}