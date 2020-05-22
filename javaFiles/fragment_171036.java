public String[] OpenFile() throws IOException {
   FileReader reader = new FileReader(path);
   BufferedReader textReader = new BufferedReader(reader);

   List<String> textData = new LinkedList<String>();//linked list to avoid realloc
   String line;
   while ((line = textReader.readLine()) != null) {
       if (!line.contains("//")) textData.add(line);
   }

   // close the line-by-line reader and return the data
   textReader.close();
   return textData.toArray(new String[textData.size()]);
}