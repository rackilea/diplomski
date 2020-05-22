// Writing a comment at the top of the xml file, then writing the Java object to the xml file
File xmlFile = new File("/", "myObject.xml");
FileOutputStream out = new FileOutputStream(xmlFile);

String xmlComment = "<!-- Comment -->"
out.write(xmlComment.getBytes());
out.write("\n".getBytes());

MyObject myObject = new MyObject();
xstream.toXML(myObject, out);

// Reading the comment from the xml file, then deserilizing the object;
final FileBasedLineReader xmlFileBasedLineReader = new FileBasedLineReader(xmlFile);
final String commentInXmlFile = xmlFileBasedLineReader.nextLine();

FileInputStream xmlFile = ...
XStream xStream = new XStream();
MyObject myObject = xStream.fromXML(xmlFile);