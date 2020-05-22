StringBuilder text = new StringBuilder();  
try (BufferedSource source = Okio.buffer(Okio.source(file))) {
 for (String line; (line = source.readUtf8Line()) != null; ) {
  text.append(line);
  text.append('\n'); 
 }
}