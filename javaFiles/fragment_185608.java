url = new URL(targetURL);

connection = (HttpsURLConnection) url.openConnection();            
connection.setRequestMethod("POST");
connection.setRequestProperty("Content-Type", 
                              "application/x-www-form-urlencoded;charset=utf-8");
connection.setRequestProperty("Accept", "application/x-www-form-urlencoded");
connection.setRequestProperty("Accept-Charset", "UTF-8");
connection.setRequestProperty("Content-Length", 
                              Integer.toString(Data.getBytes("utf8").length));
connection.setDoInput(true);
connection.setDoOutput(true);

connection.getOutputStream().write(Data.getBytes("utf8"));
// read response...