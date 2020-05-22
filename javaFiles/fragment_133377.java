URL u = new URL("http://www.google.com");
URLConnection conn = u.openConnection();
BufferedReader in = new BufferedReader(
                        new InputStreamReader(
                            conn.getInputStream()));
StringBuffer buffer = new StringBuffer();
String inputLine;
while ((inputLine = in.readLine()) != null) 
    buffer.append(inputLine);
in.close();
System.out.println(buffer.toString());