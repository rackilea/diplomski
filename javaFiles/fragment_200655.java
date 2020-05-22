@Override
protected String doInBackground(String... args) {
    try {
        try {
            URL url;
            HttpURLConnection urlConn;
            url = new URL ("myphp.php");
            urlConn = (HttpURLConnection)url.openConnection();
            urlConn.setDoInput (true);
            urlConn.setDoOutput (true);
            urlConn.setUseCaches (false);
            urlConn.setRequestProperty("Content-Type","application/json");
            urlConn.setRequestProperty("Accept", "application/json");
            urlConn.setChunkedStreamingMode(0);
            urlConn.setRequestMethod("POST");
            urlConn.connect();
            //get google account
            AccountManager am = AccountManager.get(getBaseContext()); // "this" references the current Context
            Account[] accounts = am.getAccountsByType("com.google");

            //Create JSONObject here
            JSONObject json = new JSONObject();
            json.put("regID", args[0]); //modified
            json.put("Google account", accounts[0].name);
            json.put("name", "Amanda");
            json.put("tel", "2069994444");
            json.put("latitude", args[1]); //modified
            json.put("longitude", args[2]); //modified

            String postData=json.toString();

            // Send POST output.
            OutputStreamWriter os = new OutputStreamWriter(urlConn.getOutputStream(), "UTF-8");
            os.write(postData);
            Log.i("NOTIFICATION", "Data Sent");
            os.close();

            BufferedReader reader = new BufferedReader(new InputStreamReader(urlConn.getInputStream()));
            String msg="";
            String line = "";
            while ((line = reader.readLine()) != null) {
                msg += line; }
            Log.i("msg=",""+msg);
        } catch (MalformedURLException muex) {
            // TODO Auto-generated catch block
            muex.printStackTrace();
        } catch (IOException ioex){
            ioex.printStackTrace();
        }
    } catch (Exception e) {
        e.printStackTrace();
        Log.e("ERROR", "There is error in this code");

    }
    return null;

}