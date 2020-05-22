URL url = new URL(path);
 HttpURLConnection conn = (HttpURLConnection) url.openConnection();
 conn.setRequestMethod("POST");
 conn.setConnectTimeout(10000);
 conn.setReadTimeout(2000);
 conn.setDoOutput(true);
 byte[] bypes = params.toString().getBytes();
 conn.getOutputStream().write(bypes);
 InputStream inStream = conn.getInputStream();