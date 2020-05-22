public class GoodAsync extends Activity{

TextView tv;

@Override
protected void onCreate(Bundle savedInstanceState) {
    // TODO Auto-generated method stub
    super.onCreate(savedInstanceState);
    setContentView(R.layout.asynctasks);
    tv = (TextView) findViewById(R.id.async_view);
    new AsyncTasker().execute();
}

    public void setTextView (String text) {
       tv.setText(text);
    }

    private class AsyncTasker extends AsyncTask<String, Integer, String>{

        ....

        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);
            setTextView(result);
        }   

    }
}