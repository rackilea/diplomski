public void splitFile(List<String> results) throws IOException {

  int name = 0;

  BufferedWriter out = null;
  for (int i=0; i<results.size(); i ++) {
    String line = results.get(i);
    if (line.startsWith("{")) {
       if (out != null) // it's not the first
          out.close(); // tell buffered it's going to close, it makes it flush
       FileWriter writer = new FileWriter("/home/tom/files/"+ name +".json");
       out = new BufferedWriter(writer);
       name++;
    }
    if (out == null)
       throw new IllegalArgumentException("first line doesn't start with {");
    out.write(line);
  } 

  if (out != null) // there was at least one file
     out.close();
}