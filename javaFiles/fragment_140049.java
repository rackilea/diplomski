public String doInBackground(String... urls){

        String result = "";
        try{
            URL url = new URL(urls[0]);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            InputStream in = conn.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            String line = "";

            while((line = reader.readLine()) != null){
                result = result + line;
            }

            conn.disconnect();
        }
        catch(Exception e){
            Log.e("ERROR Fetching ", e.toString());
        }
        return result;
    }