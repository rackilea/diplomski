public ArrayList<String> readWords(File file) throws IOException {
  ArrayList<String> words = new ArrayList<String>();
  String cLine = "";
  BufferedReader reader = new BufferedReader(new FileReader(file));
  while ((cLine = reader.readLine()) != null) {
    for (String word : cLine.split(" ")) {words.add(word);}
  }
  return words;
}