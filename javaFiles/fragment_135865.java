URL url = new URL(PAY_ENDPOINT);
HttpURLConnection connection = (HttpURLConnection) url.openConnection();
connection.setDoOutput(true);
connection.setRequestMethod("POST");

connection.setRequestProperty("X-PAYPAL-SECURITY-USERID", USER_ID);
connection.setRequestProperty("X-PAYPAL-SECURITY-PASSWORD", PASSWORD);
connection.setRequestProperty("X-PAYPAL-SECURITY-SIGNATURE", SIGNATURE);

connection.setRequestProperty("X-PAYPAL-APPLICATION-ID", APPLICATION_ID);

connection.setRequestProperty("X-PAYPAL-REQUEST-DATA-FORMAT", "JSON");
connection.setRequestProperty("X-PAYPAL-RESPONSE-DATA-FORMAT", "JSON");

/* Form JSON into "requestStr" */

OutputStreamWriter writer = new OutputStreamWriter(connection.getOutputStream());
writer.write(requestStr);
writer.close();

// Read response into StringBuffer
BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
StringBuffer stringBuffer = new StringBuffer();
String line = "";
while((line = reader.readLine()) != null){
    stringBuffer.append(line);
}
reader.close();