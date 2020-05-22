public void dataWriter(String data, String fileName) throws IOException {

PrintWriter writer = new PrintWriter(new FileOutputStream(new File(fileName));

try {
  writer.write(data);
} catch (Exception e) {
  System.err.println("Some exception");
} finally {
   writer.close();
}