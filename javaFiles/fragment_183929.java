public class FetchData extends AsyncTask<String, String, String> { //rename fetchData to FetchData to follow Java coding practices
    private Activity activity;

    public FetchData(Activity activity) {
        this.activity = activity;
    }

    @Override
    protected String doInBackground(String... strings) { //use the proper variable names
        //...
    }

    @Override
    protected void onPostExecute(String string) { //use the proper variable names
        //use instanceof to check the identity of the activity instance
        if (activity instanceof Activity1) {
            //whatever
        } else if (activity instanceof Activity2) {
            //whatever else
        }
        //super call isn't needed
    }
}