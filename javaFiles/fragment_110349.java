// Get an input stream for the file ...
File file = ...
InputStream stream = new BufferedInputStream(new FileInputStream(file));

Node folder = session.getNode("/absolute/path/to/folder/node");
Node file = folder.addNode("Article.pdf","nt:file");
Node content = file.addNode("jcr:content","nt:resource");
Binary binary = session.getValueFactory().createBinary(stream);
content.setProperty("jcr:data",binary);
content.setProperty("jcr:mimeType","application/pdf");