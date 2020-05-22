HttpURLConnection urlConnection = null;
    try {
        // http client

        murl=new URL(url);
        urlConnection = (HttpURLConnection) murl.openConnection();

        urlConnection.setRequestProperty("Content-Type", "application/json;odata=verbose");
        urlConnection.setRequestProperty("Accept", "application/json;odata=verbose");

        // Checking http request method type
        if (method == POST) {
            urlConnection.setRequestMethod("POST");
            urlConnection.setDoInput(true);
            urlConnection.setDoOutput(true);



            if(!jsondata.equals("null")) {
                OutputStream os = urlConnection.getOutputStream();
                BufferedWriter writer = new BufferedWriter(
                        new OutputStreamWriter(os, "UTF-8"));
                writer.write(jsondata);
                writer.flush();
                writer.close();
                os.close();
            }


        } else if (method == GET) {
            // appending params to url
            urlConnection.setRequestMethod("GET");

        }
        resCode = urlConnection.getResponseCode();
        Log.i("TAG", "response code=>" + resCode);