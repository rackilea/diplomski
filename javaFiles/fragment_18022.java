HttpURLConnection urlConnection = (HttpURLConnection) (uri.toURL().openConnection());
urlConnection.setConnectTimeout(1500);
urlConnection.setRequestMethod("POST");
urlConnection.setDoInput(true);
urlConnection.setDoOutput(true);

List<NameValuePair> params = new ArrayList<NameValuePair>();
params.add(new BasicNameValuePair("uname", uname));
params.add(new BasicNameValuePair("pass", password));
params.add(new BasicNameValuePair("email", email));

OutputStream os = urlConnection.getOutputStream();
BufferedWriter writer = new BufferedWriter(
    new OutputStreamWriter(os, "UTF-8"));
writer.write(getQuery(params));
writer.flush();
writer.close();
os.close();

urlConnection.connect();
if(urlConnection.getResponseCode() == 200){
    InputStream inputStream = new BufferedInputStream(urlConnection.getInputStream());
    BufferedReader streamReader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
    StringBuilder responseStrBuilder = new StringBuilder();

    String inputStr;
    while ((inputStr = streamReader.readLine()) != null)
        responseStrBuilder.append(inputStr);
    JSONObject json = new JSONObject(responseStrBuilder.toString());
    String message = json.getString("message");
}