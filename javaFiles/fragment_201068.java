BufferedReader br = new BufferedReader(filein);
ArrayList<String> content = new ArrayList<String>();
String line = br.readLine();
while(line != null){
    //add lines to ArrayList
    content.add(line);
    line = br.readLine();
}