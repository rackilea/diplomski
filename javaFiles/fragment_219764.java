InputStream inputStream = conn.getInputStream(); 
BufferedReader br = new BufferedReader(new InputStreamReader(inputStream)); 
while(br.ready()){ 
    String line = br.readLine(); 
    //line has the contents returned by the inputStream 
}