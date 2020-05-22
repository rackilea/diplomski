@Get ("xml")
public String getRootDeviceXML() throws IOException {
    BufferedReader br = new BufferedReader(new FileReader(xmlFile));
    String line;
    StringBuilder sb = new StringBuilder();

    while((line=br.readLine())!= null){
        sb.append(line.trim());
    }

    br.close();

    return sb.toString();
}