public class ConnectionAsyncTask extends AsyncTask<String,String,String> {
    Activity activity;
    private EventListener listener;
    private TextView mTextView

    public ConnectionAsyncTask(Activity activity, TextView txt) {
        this.activity=activity;
       this.mTextView=txt;
    }
    @Override
    protected String doInBackground(String... params) {
        String content =HttpManager.getData(params[0]);
        return content;
    }
    @Override
    protected void onProgressUpdate(String... values) {
        super.onProgressUpdate(values);
    }
    @Override
    protected void onPostExecute(String s) {
        List<Country> countries= CountryJasonParser.getObjectFromJason(s);
        if (countries != null) {
            String s1 = "";

                s1=s1+"\n"+"" + countries.get(0).getDes() ;

                mTextView.setText(s1);
        } 
    }
}