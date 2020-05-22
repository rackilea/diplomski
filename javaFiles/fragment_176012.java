public void doPost() throws SQLException{
try {
    URL url = new URL("http://sbt-ot-289.ca.sbrf.ru:8080/ptd_integration/");
    urlConnection = (HttpURLConnection) url.openConnection();
    urlConnection.setRequestProperty("Content-Type", "application/json");
    urlConnection.setRequestMethod("POST");
    urlConnection.setDoOutput(true);
    urlConnection.setDoInput(true);
    urlConnection.connect();
    System.out.println("Connection succesfull");
    OutputStreamWriter wr = new OutputStreamWriter(urlConnection.getOutputStream());
    wr.write(usersCollection().toString());
    wr.flush();

    StringBuilder sb = new StringBuilder();
    int HttpResult = urlConnection.getResponseCode();
    if (HttpResult == HttpURLConnection.HTTP_OK){
        BufferedReader br = new BufferedReader(new InputStreamReader(urlConnection.getInputStream(),"utf-8"));
        String line;
       while ((line = br.readLine()) !=null){
            sb.append(line);
        }
        br.close();
        System.out.println(sb.toString());
    }else {
        System.out.println(urlConnection.getResponseMessage());
    }
} catch (IOException e) {
    e.printStackTrace();
}
finally {
    urlConnection.disconnect();
}