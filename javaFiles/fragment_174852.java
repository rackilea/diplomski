public void listFiles(String folder){
File directory = new File(folder);
File[] contents = directory.listFiles();
for ( File f : contents) {
  System.out.println(f.getAbsolutePath());
}