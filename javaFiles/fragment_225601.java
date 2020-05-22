String para = "username=123&password=321"
HttpURLConnection connection = (HttpURLConnection) url.openConnection();
connection.setRequestMethod("POST");
connection.setRequestProperty("Content-Language", "en-US");
connection.setRequestProperty("Content-Length", Integer.toString(para.getBytes().length));
connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
connection.setUseCaches(false);
connection.setDoInput(true);
connection.setDoOutput(true);

OutputStreamWriter osw = new DataOutputStream(connection.getOutputStream());
osw.writeBytes(para);
osw.flush();

BufferedReader mBufferedReader = new BufferedReader(new InputStreamReader(this.mConnection.getInputStream()));
StringBuilder mStringBuilder = new StringBuilder();
String line = "";
while((line = mBufferedReader.readLine()) != null){
    mStringBuilder.append(line);
}
String responseString = mStringBuilder.toString();