String params = "grant_type=password&username=xyz&password="+ java.net.URLEncoder.encode("urp&^!ass", "UTF-8");
OutputStream os = connection.getOutputStream();
BufferedWriter writer = new BufferedWriter( new OutputStreamWriter(os, "UTF-8"));
writer.write(params);
writer.flush();
writer.close();
os.close();
int responseCode = connection.getResponseCode();