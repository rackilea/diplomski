class MyAsyncTask extends AsyncTask<URL, Integer, Long> {

    Activity mActivity;

    //constructor. 
    public MyAsyncTask(Activity activity) {
       mActivity = ativity;
    }

   ...

   protected void onPostExecute(String result){
       TextView tv = mActivity.findViewById(...);
       tv.setText(result);
   }
}