public void onClick(View v) {
switch (v.getId())
{
   new Lichterkette().execute();
 }
}


    class Lichterkette extends AsyncTask<String,Void,String>{
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
            }

            @Override
            protected String doInBackground(String... params) {
                StringBuilder sb=null;
                BufferedReader reader=null;
                String serverResponse=null;
                try {

                    URL url = new URL("http://192.168.2.106/?Lichterkette=1");
                    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                    connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
                    connection.setConnectTimeout(5000);
                    connection.setRequestMethod("GET");
                    connection.connect();
                    int statusCode = connection.getResponseCode();
                    //Log.e("statusCode", "" + statusCode);
                    if (statusCode == 200) {
                        sb = new StringBuilder();
                        reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                        String line;
                        while ((line = reader.readLine()) != null) {
                            sb.append(line + "\n");
                        }
                    }

                    connection.disconnect();
                    if (sb!=null)
                        serverResponse=sb.toString();
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    if (reader != null) {
                        try {
                            reader.close();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
                return serverResponse;
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
               //All your UI operation can be performed here
                System.out.println(s);
            }
        }