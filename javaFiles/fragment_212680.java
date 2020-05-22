InputStream inputStream = 
        getClass().getClassLoader().getResourceAsStream("file.txt");
BufferedReader buf = new BufferedReader(new InputStreamReader(inputStream));
String line = "";

while((line = buf.readLine()) != null){
    // something 
}