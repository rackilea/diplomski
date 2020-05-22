public static void writeText(String[] text){
  Path file = Paths.get("/tmp/filename");
  try (BufferedWriter bw = Files.newBufferedWriter(file, StandardCharsets.UTF_8)) {
    for(String s : text){
      bw.write(s);
      bw.write("\n");
    }
  } catch (IOException e) {
    System.err.println("Failed to write to "+file);
  }
}