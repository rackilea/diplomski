new AsyncTask<Void, Void, Void>(){

            @Override
            protected Void doInBackground(Void... params) {

                try {
                    String result = callWebService("http://necrecords.16mb.com/getlink.php?password=acchata%20mucchata");
                    JSONArray resArray = new JSONArray(result);
                    for (int i=0; i<resArray.length();i++){
                        JSONObject res = resArray.getJSONObject(i);

                        String link = res.getString("link");
                        String test = res.getString("test");
                        Log.v("result ==== ", link + "   ,   " + test);
                    }

                }
                catch (Exception e){
                    e.printStackTrace();
                }


                return null;
            }
        }.execute();




public String callWebService(String urlvalue) throws Exception {
        System.setProperty("http.keepAlive", "false");
        URL u = new URL(urlvalue);
        URLConnection conn = u.openConnection();
        BufferedReader in = new BufferedReader(new InputStreamReader(
                conn.getInputStream()));
        StringBuffer buffer = new StringBuffer();
        String inputLine;
        while ((inputLine = in.readLine()) != null)
            buffer.append(inputLine);
        in.close();
        // System.out.println(buffer.toString());
        return buffer.toString();

    }