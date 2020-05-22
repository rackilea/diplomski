String IP= "123.123.123.123";
URL link = new URL("http://www.geobytes.com/IpLocator.htm?GetLocation&template=php3.txt&IpAddress="+IP);

BufferedReader in = new BufferedReader(new InputStreamReader(link.openStream()));
String inputLine;

while ((inputLine = in.readLine()) != null){
     System.out.println(inputLine);             
}

in.close();