private class AsyncTaskRunner extends AsyncTask<String, String, String>{

    private Context context;
    private String NEKI_STRING;
    private String listItemString;

    public AsyncTaskRunner(Context context ,String neki_string, String listItemString){

        this.context = context;
        NEKI_STRING = neki_string;
        this.listItemString = listItemString;
    }

    @Override
    protected String doInBackground(String... params) {


        if(isNetworkAvailable(context)){


            return "OK";


        }

        return "";
    }

    @Override
    protected void onPostExecute(String reply) {
        super.onPostExecute(reply);

        if(reply.equals("OK")) {
            try{
            Intent intent=new Intent(getApplicationContext(),RssActivity.class);
            intent.putExtra(NEKI_STRING,listItemString);
            startActivity(intent);
            }catch(Exception e){

            }
        }
    }