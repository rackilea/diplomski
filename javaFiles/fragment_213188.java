public class DownloadTask extends AsyncTask<String, Void, String>{

        @Override
        protected String doInBackground(String... buttoks) {

            URL url;
            HttpURLConnection httpURLConnection = null;
            String result = "";
            StringBuffer buf = new StringBuffer(); 

            // try catch for if malformed url
            try {
                url = new URL(buttoks[0]);

                httpURLConnection = (HttpURLConnection)url.openConnection();

                InputStream in = httpURLConnection.getInputStream();

                BufferedReader reader =new BufferedReader(new InputStreamReader(in));

                if (is != null) {                            
                    while ((result = reader.readLine()) != null) {    
                        buf.append(result);
                    }                
                }

                return  buf.toString();

            } catch (Exception e) {
                e.printStackTrace();
                return "failed";
            }

        }

        @Override
        ... onPostExecute(String str){
                // update UI here
        }
    }