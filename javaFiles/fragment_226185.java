public class Connection extends AsyncTask<String, Void, String> {
       private OnTaskCompleted listener;

       public Connection(OnTaskCompleted listener){
           this.listener=listener;
       }
       String finalData="123";
       @Override
       protected String doInBackground(String... urls) {