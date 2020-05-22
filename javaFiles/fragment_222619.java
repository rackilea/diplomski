conn.setRequestMethod("POST");
conn.addRequestProperty("Content-Type", "application/x-www-form-urlencoded");
byte[] requestBody = urlParameters.getBytes("UTF-8");
conn.setFixedLengthStreamingMode(requestBody.length);
try (OutputStream out = conn.getOutputStream()) {
    out.write(requestBody);
    out.flush();
}