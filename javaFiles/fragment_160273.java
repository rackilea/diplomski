class Logging extends AsyncTask<String,String,Void>{
    JSONObject json=null;
    String output="";
    String log=StringCheck.buildSpaces(login.getText().toString());
    String pas=StringCheck.buildSpaces(password.getText().toString());
    String url="http://www.mastah.esy.es/webservice/login.php?login="+log+"&pass="+pas;

    protected void onPreExecute() {
        Toast.makeText(getApplicationContext(), "Operation pending, please wait", Toast.LENGTH_SHORT).show();
     }

    @Override
    protected Void doInBackground(String... params) {
        HttpClient client = new DefaultHttpClient();
        HttpGet request = new HttpGet(url);
        request.addHeader("User-Agent", "User-Agent");
        HttpResponse response;
        try {
            response = client.execute(request);
            BufferedReader br = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
            String line="";
            StringBuilder result = new StringBuilder();
            while ((line = br.readLine()) != null) {
                result.append(line);
            }
            output=result.toString();
        } catch (ClientProtocolException e) {
            Toast.makeText(getApplicationContext(), "Connection problems", Toast.LENGTH_LONG).show();
        } catch (IOException e) {
            Toast.makeText(getApplicationContext(), "Conversion problems", Toast.LENGTH_LONG).show();
        }
        return null;
    }

    @Override
    protected void onPostExecute(Void w) {
        try {
            json = new JSONObject(output);
            if(json.getInt("err")==1){
                Toast.makeText(getApplicationContext(), json.getString("msg"), Toast.LENGTH_LONG).show();
            }else{
                String id_user="-1";
                Toast.makeText(getApplicationContext(), json.getString("msg"), Toast.LENGTH_LONG).show();
                JSONArray arr = json.getJSONArray("data");
                for(int i =0;i<arr.length();i++){
                    JSONObject o = arr.getJSONObject(i);
                    id_user = o.getString("id_user");
                }
                User.getInstance().setName(log);
                User.getInstance().setId(Integer.valueOf(id_user));
                Intent i = new Intent(getApplicationContext(),Discover.class);
                startActivity(i);
            }
        } catch (JSONException e) {
        }
        super.onPostExecute(w);
    }   
}