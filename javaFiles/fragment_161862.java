AsyncTask<Void,Void,String> getDBdata = new AsyncTask<Void, Void, String>() {
    @Override
    protected String doInBackground(Void... params) {
        URL url = null;
        try {
            url = new URL(Constants.SERVER_URL + getDBdataURL);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        String text;
        text = null;
        try {
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestProperty("Accept-Charset", "UTF-8");
            connection.setRequestProperty("User-Agent", "Mozilla/5.0 ( compatible ) ");
            connection.setRequestProperty("Accept", "*/*");
            connection.setChunkedStreamingMode(0);
            connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            connection.setDoOutput(true);
            connection.setRequestMethod("POST");
            String request = "action=getDBdata";
            PrintWriter pw = new PrintWriter(connection.getOutputStream());
            pw.print(request);
            pw.close();
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder builder = new StringBuilder();
            String aux = "";
            while ((aux = in.readLine()) != null) {
                builder.append(aux);
            }
            text = builder.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return text;
    }