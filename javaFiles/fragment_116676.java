int responseCode=conn.getResponseCode();
        if (responseCode == HttpsURLConnection.HTTP_OK) {
            Log.d("nugi", "Got Here 3");
            String line;
            BufferedReader br=new BufferedReader(new 
            InputStreamReader(conn.getInputStream(), "iso-8859-1"));
            Log.d("nugi", "Got Here 4");
            while ((line=br.readLine()) != null) {
                response+=line;
                Log.d("nugi", "Got Here 5");
            }
            Log.d("nugi", response);

            Response = response;
        } else {
            String line;
            BufferedReader br=new BufferedReader(new 
            InputStreamReader(conn.getErrorStream(), "iso-8859-1"));
            Log.d("nugi", "Got Here 4");
            while ((line=br.readLine()) != null) {
                response+=line;
                Log.d("nugi", "Got Here 5");
            }
            Log.d("nugi", response);

            Response = response;
        }