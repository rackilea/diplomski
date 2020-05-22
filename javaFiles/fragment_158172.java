String myurl="example.com";
URL url = new URL(myurl); 
URLConnection conn = (HttpURLConnection)url.openConnection();
conn.setRequestMethod("POST");
conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
conn.setRequestProperty("Content-Language", "en-US");
conn.setUseCaches (false);
conn.setDoInput(true);
conn.setDoOutput(true);