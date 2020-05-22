URLConnection connection = new URL(url).openConnection();
 connection.setDoOutput(true); // Triggers POST.
 connection.setRequestProperty("Accept-Charset", charset);
 connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded;charset=" +    charset);
 OutputStream output = null;
 try {
    output = connection.getOutputStream();
    output.write(query.getBytes(charset));
  } finally {
   if (output != null) try { output.close(); } catch (IOException logOrIgnore) {}
  }
  InputStream response = connection.getInputStream();
  // ...