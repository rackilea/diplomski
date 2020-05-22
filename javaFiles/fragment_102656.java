public String getOutputOf(String jarfile) throws IOException{
    ProcessBuilder builder = new ProcessBuilder ("java", "-jar",  jarfile); 
    builder.redirectErrorStream(true); 
    Process process = builder.start();             
    BufferedReader reader = new BufferedReader (new InputStreamReader(process.getInputStream())); 
    StringBuilder sb = new StringBuilder();
    String line = "";
    while ((line = reader.readLine()) != null) {
        sb.append(line + "\n");
    }
    return sb.toString();
}