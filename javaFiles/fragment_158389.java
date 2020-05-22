ArrayList<String> time = new ArrayList<String>();
ArrayList<String> g = new ArrayList<String>();
ArrayList<String> gd = new ArrayList<String>();
ArrayList<String> td = new ArrayList<String>();

String line = "";

//get a BufferedReader for your file.

while((line = br.readLine) != null){
    String row = line.split(" ");
    time.add(row[0]);
    g.add(row[1]);
    gd.add(row[2]);
    td.add(row[3]);
}