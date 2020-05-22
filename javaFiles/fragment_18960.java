protected void onCreate(Bundle savedInstanceState){
            super.onCreate(savedInstanceState);
            setContentView(R.layout.report_activity);
            et = (EditText)findViewById(R.id.myedit);
            btn =(Button)findViewById(R.id.mybutton);

    btn.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v){
               mname = et.getText().toString();
            // show response on the EditText etResponse 

            try {
                query = URLEncoder.encode(mname, "utf-8");
            } catch (UnsupportedEncodingException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

            mylink = "http://necrecords.16mb.com/complaints.php?username="+query;

             HttpAsyncTask hat = new HttpAsyncTask();
             hat.execute(mylink);


                }

            });

        }        


    private class HttpAsyncTask extends AsyncTask<String, Void, String> {

                    @Override
                    protected String doInBackground(String... urls) {

                        return httpRequestResponse(urls[0]);
                    }
                    // onPostExecute displays the results of the AsyncTask.
                    @Override
                    protected void onPostExecute(String result) {

                    }
                }

            //For HttpAsync Functions: sending requests and receiving responses
                public static String httpRequestResponse(String url){
                    InputStream inputStream = null;
                    String result = "";
                    try {
                        // create HttpClient
                        HttpClient httpclient = new DefaultHttpClient();

                        // make GET request to the given URL
                        HttpResponse httpResponse = httpclient.execute(new HttpGet(url));

                        // receive response as inputStream
                        inputStream = httpResponse.getEntity().getContent();

                        // convert InputStream to string
                        if(inputStream != null)
                            result = convertInputStreamToString(inputStream);
                        else
                            result = "InputStream did not work";

                    } catch (Exception e) {
                        Log.d("InputStream", e.getLocalizedMessage());
                    }

                    return result;
                }

        private static String convertInputStreamToString(InputStream inputStream) throws IOException{
                BufferedReader bufferedReader = new BufferedReader( new InputStreamReader(inputStream));
                String line = "";
                String result = "";
                while((line = bufferedReader.readLine()) != null)
                    result += line;

                inputStream.close();
                return result;
            }