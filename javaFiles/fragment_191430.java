private String readFromStream(InputStream inputStream) throws IOException {
    StringBuilder output = new StringBuilder();
    if (inputStream != null) {
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream, Charset.forName("UTF-8"));
        BufferedReader reader = new BufferedReader(inputStreamReader);
        String line = reader.readLine();
        while (line != null) {
            output.append(line);
            line = reader.readLine();
        }
    }
    return output.toString();
}

 try{
        String response = "";
        Log.d("connect_server","is connect");
        URL url = new URL("someurl");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setDoInput(true);
        connection.setDoOutput(true);
        connection.setRequestMethod("POST");
        connection.setUseCaches(false);

        OutputStreamWriter osw=new OutputStreamWriter(connection.getOutputStream());
        Log.d("post param",params);
        osw.write(params);
        osw.flush();
        osw.close();
        connection.connect();
        if (urlConnection.getResponseCode() == 200) {
            inputStream = urlConnection.getInputStream();
            response = readFromStream(inputStream);
        }

        // now response has your server response use it however you want


    }catch (IOException e)
    {
        e.printStackTrace();
    }