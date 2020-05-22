public String[] OpenFile() throws IOException {

  FileReader fr = new FileReader(path);
  BufferedReader textReader = new BufferedReader(fr);

  //int numberOfLines = 0; //this is not needed

  List<String> textData = new ArrayList<String>(); //we don't know how many lines are there going to be in the file

  //this part should work akin to the readLines part
  String aLine;
  while ((aLine = bf.readLine()) != null) {
      textData.add(aLine); //add the line to the list
  }

  textReader.close();
  return textData.toArray(new String[textData.size()]); //convert it to an array, and return
 }
}