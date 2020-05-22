public class AsyncAdapter extends AsyncTask<Void, Void, Void> {
@Override
protected Void doInBackground(Void... params) {

    //This line will load the files into shared preferences (DataSource is my sharedPreferences)
    Loader.loadPhoneStickers(adapter.getDataSource()); 

    //this will cause the list that the adapter is attached to, to get updated and load all the items that were added to shared preferences 
    //this method will make a call to getAllItems and notifyItemRangeChanged
    return null;
    }

 @Override
 protected void onPostExecute(Void aVoid) {
    super.onPostExecute(aVoid);

      adapter.refresh();
  }
}