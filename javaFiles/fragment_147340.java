BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream()));
      String json = "";

            if (br != null) {
                json = br.readLine();
            }
 JSONObject wholedata= new JSONObject(json);