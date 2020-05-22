int responseCode = con.getResponseCode();
System.out.println("Response Code : " + responseCode);

BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
String inputLine;
StringBuffer response = new StringBuffer();

while ((inputLine = in.readLine()) != null) {
response.append(inputLine);
}
in.close();

//print result
System.out.println(response.toString());