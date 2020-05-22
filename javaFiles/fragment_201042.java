if (statusCode != 200) {
  InputStream errorStream = connection.getErrorStream();
  String errorMessage = (errorStream != null) ? readErrorString(errorStream) : connection
                .getResponseMessage();
}
private void readErrorString(InputStream is) {
  String responseString = null;
  BufferedInputStream bis = null;
  try {
    StringBuilder sb = new StringBuilder();
    bis = new BufferedInputStream(inputStream);
    byte[] byteContents = new byte[4096];
    int bytesRead;
    String strContents;
    while ((bytesRead = bis.read(byteContents)) != -1) {
        strContents = new String(byteContents, 0, bytesRead, "UTF-8"); // You might need to replace the charSet as per the responseEncoding returned by httpurlconnection above
            sb.append(strContents);
    }
    responseString = sb.toString();
} finally {
    if (bis != null) {
        bis.close();
        }
    }
}