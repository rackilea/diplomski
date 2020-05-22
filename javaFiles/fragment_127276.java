BufferedReader br = new BufferedReader(new FileReader(new File("path/to/file")));

String currentLine = br.readLine();

Map<Integer, String> nameByID = new HashMap<Integer, String>(); 
while (currentLine != null) {

  String[] tokens = currentLine.split("\t");
  int id = Integer.parseInt(tokens[2]);
  String name = tokens[4];
  nameByID.put(id, name);
  currentLine = br.readLine();

}

br.close();