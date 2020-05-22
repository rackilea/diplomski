URL endpoint = null;

endpoint = new URL("https://someurlhere.com");

conn = (HttpURLConnection) endpoint.openConnection();

// Set the necessary header fields

//The SOAPAction is required to be blank
/*The presence and content of the SOAPAction header field can be used by servers such as firewalls to appropriately
filter SOAP request messages in HTTP. The header field value of empty string ("") means that the intent of the SOAP
message is provided by the HTTP Request-URI. No value means that there is no indication of the intent of the message.*/
conn.addRequestProperty("SOAPAction", "");
//Telling the server not to Skip the SOAPAction. It's a mandatory field when we send SOAP Requests.
conn.addRequestProperty("Skip SOAP Action", "false");
conn.addRequestProperty("Content-Type", "text/xml;charset=UTF-8");

//We use POST because we are sending data to the server
conn.setRequestMethod("POST");
//This is required to read response from Server
conn.setDoOutput(true);
//The server has 5 seconds to respond. Else, a timeout occurs and the connection is terminated.
conn.setConnectTimeout(5000);

// Send the request
OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());
wr.write(xmlContent);
wr.flush();


// Read the response
BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
String temp;

//Reading as long as there is response to read
while ((temp = rd.readLine()) != null) {
    response += temp;
}