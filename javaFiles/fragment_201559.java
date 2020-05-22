class Async extends AsyncTask<String, String, String> {

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        progressDialog = new ProgressDialog(MyActivity.this);
        progressDialog.setTitle("Merci de patienter");
        progressDialog.setMessage("Chargement en cours");
        progressDialog.setCancelable(false);
        progressDialog.setIndeterminate(true);
        progressDialog.show();
    }

    @Override
    protected String doInBackground(String... aurl) {

        try {
            HttpClient client = new DefaultHttpClient();
            HttpGet get = new HttpGet("http://localhost");
            HttpResponse response = client.execute(get);
            StatusLine status = response.getStatusLine();
            String data = status.toString();    

            return data;
        } catch (Exception e) {}
        return null;

    }

    @Override
    protected void onPostExecute(String result) {
        if (progressDialog!=null) {
            progressDialog.dismiss();
        }
         tvStatus.setText(result);

    }
}

    @Override
        protected void onCreate(Bundle savedInstanceState) {
            // TODO Auto-generated method stub
            super.onCreate(savedInstanceState);
            setContentView(R.layout.json);  
            tvStatus = (TextView) findViewById(R.id.tvStatus);
            new Async().execute();
    }