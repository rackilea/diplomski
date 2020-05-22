static void readFile(ArrayList<Items> list) throws IOException {
    BufferedReader in = new BufferedReader(
        new FileReader("input.txt")
    );
    String text;
    while( (text = in.readLine()) != null ) {
        if(text.length()==0) break;
        Scanner line = new Scanner(text);
        linha.useDelimiter("\\s*:\\s*");
        String name = line.next();
        int qtt = line.nextInt();
        Items i = new Items();
        i.name = name.toLowerCase();
        i.qtt = qtt;
        list.add(i);
    }
    in.close();            
}