NPOIFSFileSystem fs = new NPOIFSFileSystem(new File("test.doc"));
HPSFPropertiesOnlyDocument doc = new HPSFPropertiesOnlyDocument(fs);

SummaryInformation si = doc.getSummaryInformation();
if (si == null) doc.createInformationProperties();

si.setAuthor("StackOverflow");
si.setTitle("Properties Demo!");

FileOutputStream out = new FileOutputStream("changed.doc");
doc.write(out);
out.close();