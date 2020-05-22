private class DownloadTask extends AsyncTask<URL, Void, ArrayList<Item>> {

     boolean isDone = false;

     protected Long doInBackground(URL... urls) {

         ArrayList<Item> goodItems = new ArrayList<Item>();

         while (goodItems.size() < 20 || isDone != true) {
            // request and adding of items to goodItems
         }

         return goodItems;
     }

     protected void onPostExecute(ArrayList<Item> result) {
        // update views
     }
 }