FileInputStream fis;
try {
  fis = new FileInputStream(file);
} catch (FileNotFoundException fnfe) {
  return;
}

try {

  Document doc = new Document();

  String line = null;
  try (BufferedReader reader = new BufferedReader(new InputStreamReader(fis, StandardCharsets.UTF_8))) {
    line = reader.readLine();
    Field headerField = new TextField("header", line, Field.Store.YES);
    headerField.setBoost(2.0F);
    doc.add(headerField);
    while ((line = reader.readLine()) != null ) {
        doc.add(new TextField("contents", line, Field.Store.YES));
        }
    } catch (IOException e) {
        System.err.println(e);
    }

} finally {
  fis.close();
}