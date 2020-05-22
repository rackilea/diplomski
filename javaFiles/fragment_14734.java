FileReader reader = new FileReader("file1.txt");
    BufferedReader br  = new BufferedReader(reader);
    String line="";
    while((line=br.readLine())!=null){
        if(!line.startsWith("#")){
            System.out.println(line);
        }
    }
}