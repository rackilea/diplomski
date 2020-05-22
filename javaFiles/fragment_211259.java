if (con.getResponseCode() == HttpsURLConnection.HTTP_OK 
               || con.getResponseCode() == HttpsURLConnection.HTTP_ACCEPTED ) {
        String line;
        BufferedReader br=new BufferedReader(new InputStreamReader(con.getInputStream()));
        while ((line=br.readLine()) != null) {
            JSONObject json = new JSONObject(br.toString()); 
            if(json.getString("userPin") == null) {
               //do something here or define the default value
            }else {
                userPinRetrieved = json.getString("userPin");
            }
        }
    }