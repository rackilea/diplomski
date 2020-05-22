InputStream iStream = new FileInputStream("filename.json"); 
BufferedReader bReader = new BufferedReader(new InputStreamReader(iStream));
String line; 
String content = "";
while((line = bReader.readLine()) != null) { 
    content += line;
}