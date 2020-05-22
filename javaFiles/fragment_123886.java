public class Worker extends SwingWorker<Void, Void> {

        @Override
        protected Void doInBackground() throws Exception {
           //here you make heavy task this is running in another thread not in EDT
           int i = 0;
           setProgress(i);
           // call query 1
           while(i < 50){
             setProgress(i++);
             Thread.sleep(5); // random magic number
           }
           // then call query 2
           while(i <= 100){
             setProgress(i++);
             Thread.sleep(5); // random magic number
           }

           return null;
        }
    }