HttpResponse response = httpclient.execute(httpget);
StringBuilder sb = new StringBuilder();
DataInputStream in = new DataInputStream(response.getEntity().getContent()); 
String line;     
while ((line = in.readLine()) != null) { 
    sb.append(line);
} 
in.close(); 
String json = sb.toString();