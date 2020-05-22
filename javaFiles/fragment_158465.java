String[][] resultArray;

List<String> lines = Files.readAllLines(Paths.get("table.txt"), StandardCharsets.UTF_8);

//lines.removeAll(Arrays.asList("", null)); // <- remove empty lines

resultArray = new String[lines.size()][]; 

for(int i =0; i<lines.size(); i++){
  resultArray[i] = lines.get(i).split("\t"); //tab-separated
}