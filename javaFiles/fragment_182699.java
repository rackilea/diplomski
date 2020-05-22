public class Worker extends SwingWorker<Void, String> {

    @Override
    protected void doInBackground() throws Exception {
       //here you make heavy task this is running in another thread not in EDT
       // call your smslib
       setProgress(0);
       // do some another operation
       setProgress(43);
       // another operation
       setProgress(89);
       .
       .
    }
}