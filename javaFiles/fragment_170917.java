try {
        HttpResponse response = httpclient.execute(httppost);           
        HttpEntity entity = response.getEntity();

        inputStream = entity.getContent();
        // json is UTF-8 by default
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"), 8);
        StringBuilder sb = new StringBuilder();

        String line = null;
        while ((line = reader.readLine()) != null)
        {
            sb.append(line + "\n");

        }
        result = sb.toString();
        JSONObject jObject = new JSONObject(result);
        String ipString = jObject.getString("ip");
        Log.d("ip", ipString);

        TextView myTextView = (TextView) findViewById(R.id.textview1);
        myTextView.setText(ipString);

    } catch (Exception e) { 
        // Oops
    }
    finally {
        try{if(inputStream != null)inputStream.close();}catch(Exception squish){}
    }