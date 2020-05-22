public class MySwingWorker extends SwingWorker<String,String> {

       @Override
       public String doInBackground() {
           //here you make heavy task in another thread
           // you call publish or setProgress or both
       }

       @Override
       protected void done() {
           //here is call when job is done, you can update here your gui
       }

      public void process(List<String> chunks){
          // this is called when you do publish in the background here
          // you update the gui
      }

}