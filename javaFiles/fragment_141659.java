//Sender.java
String url = "http://localhost:8082/";
URL obj = new URL(url);
HttpURLConnection con = (HttpURLConnection) obj.openConnection();


con.setRequestMethod("POST");       
con.setDoOutput(true);

OutputStream os = con.getOutputStream();
os.write("Just Some Text".getBytes("UTF-8"));
os.flush();

int httpResult = con.getResponseCode(); 
con.disconnect();