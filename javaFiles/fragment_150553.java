try(BufferedReader in = new BufferedReader(new FileReader("file"))){
    String line;
    while((line=in.readLine())!=null){
        String[] values = line.split(" ");
        for(String v:values){
            String[] coords = v.split(",");
            int x = Integer.parseInt(coords[0]);
            int y = Integer.parseInt(coords[1]);
}