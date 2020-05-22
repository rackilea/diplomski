protected Document getDocument(File f) throws Exception {
  Document doc = new Document();
  Field contents = new Field("contents", new Scanner(f).useDelimiter("\\A").next(), Store.YES, Index.NO);  // you should actually close the scanner
  Field filename = new Field("filename", f.getName(), Store.YES, Index.ANALYZED);
  doc.add(contents);
  doc.add(filename);
  return doc;
}