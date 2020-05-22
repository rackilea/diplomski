public String getFileInformation() throws IOException {   
 try{
    String file;
    file = "tra.srt";
    Charset charset = Charset.defaultCharset();
    Path path = Paths.get(file);
    BufferedReader reader = Files.newBufferedReader(path, charset);
    System.out.printf("Lines from %s:%n",file);
    String line;

    while((line = reader.readLine()) != null) {
    if (line.indexOf(':') != -1 && line.indexOf(',') != -1 && line.indexOf('0') != -1) { 
    return line.substring(0, 12); 
    }
    }
    }catch(FileNotFoundException ex){
    System.err.println(ex);
    }

    return "";
}