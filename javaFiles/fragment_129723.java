String yamlPath="c:/test.yaml";     
    BufferedReader br = new BufferedReader(new FileReader(yamlPath));
    String resultString="";
    Yaml yaml= new Yaml();      
    try {           
        StringBuilder sb = new StringBuilder();
        String line = br.readLine();
        while (line != null) {
            sb.append(line);
            sb.append("\n");
            line = br.readLine();
        }
        resultString=sb.toString();             
    } finally {
        br.close();         
    }