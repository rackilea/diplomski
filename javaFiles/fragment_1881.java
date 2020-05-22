public class DownloadJSON extends AsyncTask<Void, Void, Void> {  
    protected Void doInBackground(Void... params) {
     // Your Existing Code
   }

   protected void onPostExecute(Void result) {
     // Refresh your list here and make sure you have data in your array
     adapter.notifyDataSetChanged();
 }