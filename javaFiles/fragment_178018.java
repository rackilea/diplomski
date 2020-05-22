try {
  FileReader fileReader = new FileReader(filename);
  BufferedReader bufferedReader = new BufferedReader(fileReader);
  List<String> lines = new ArrayList<String>();
  String line = null;
  while ((line = bufferedReader.readLine()) != null) {
     lines.add(line);
  }
  bufferedReader.close();    
}