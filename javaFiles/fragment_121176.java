ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
InputStream fileInput = classLoader.getResourceAsStream(configFileName);
if(fileInput == null){
    //File not found
}else{
    //File found
    InputStreamReader sr = new InputStreamReader(fileInput);
    BufferedReader br = new BufferedReader(sr);
    try {
        while((line = br.readLine()) != null) { 
            //Read file line by line
        }
    }catch (IOException e) {
        throw new IOException("Error parsing file: " + e.getMessage());
    }
}