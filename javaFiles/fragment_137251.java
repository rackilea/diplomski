HttpURLConnection myConnection = (HttpURLConnection) ((new URL("myurl").openConnection()));
myConnection.setDoOutput(true);
myConnection.setRequestProperty("Content-Type", "application/json");
myConnection.setRequestProperty("Accept", "application/json");
myConnection.setRequestMethod("POST");
myConnection.connect();

String jsonData = "{'foo' : 'bar'}";
byte[] outputBytes = jsonData.getBytes("UTF-8");
OutputStream os = myConnection.getOutputStream();
os.write(outputBytes);
os.close();