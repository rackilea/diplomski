URL url = new URL("http://yoururl.com");
HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
conn.setReadTimeout(10000);
conn.setConnectTimeout(15000);
conn.setRequestMethod("POST");
conn.setDoInput(true);
conn.setDoOutput(true);

List<NameValuePair> params = new ArrayList<NameValuePair>();
params.add(new BasicNameValuePair("name", "Chatura"));

OutputStream os = conn.getOutputStream();
BufferedWriter writer = new BufferedWriter(
        new OutputStreamWriter(os, "UTF-8"));
writer.write(getQuery(params));
writer.flush();
writer.close();
os.close();

conn.connect();