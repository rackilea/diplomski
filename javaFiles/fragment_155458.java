Folder folder = (Folder) getSession().getObjectByPath("/cmis-demo");

String timeStamp = new Long(System.currentTimeMillis()).toString();
String filename = "cmis-demo-doc (" + timeStamp + ")";

// Create a doc
Map <String, Object> properties = new HashMap<String, Object>();
properties.put(PropertyIds.OBJECT_TYPE_ID, "cmis:document");
properties.put(PropertyIds.NAME, filename);
String docText = "This is a sample document";
byte[] content = docText.getBytes();
InputStream stream = new ByteArrayInputStream(content);
ContentStream contentStream = getSession().getObjectFactory().createContentStream(filename, Long.valueOf(content.length), "text/plain", stream);

Document doc = folder.createDocument(
           properties,
           contentStream,
           VersioningState.MAJOR);

System.out.println("Created: " + doc.getId());
System.out.println("Content Length: " + doc.getContentStreamLength());
System.out.println("Version label:" + doc.getVersionLabel());

// Now update it with a new version
if (doc.getAllowableActions().getAllowableActions().contains(org.apache.chemistry.opencmis.commons.enums.Action.CAN_CHECK_OUT)) {
   doc.refresh();
   String testName = doc.getContentStream().getFileName();
   ObjectId idOfCheckedOutDocument = doc.checkOut();
   Document pwc = (Document) session.getObject(idOfCheckedOutDocument);
   docText = "This is a sample document with an UPDATE";
   content = docText.getBytes();
   stream = new ByteArrayInputStream(content);         
   contentStream = getSession().getObjectFactory().createContentStream(filename, Long.valueOf(content.length), "text/plain", stream);          
   ObjectId objectId = pwc.checkIn(false, null, contentStream, "just a minor change");
   doc = (Document) session.getObject(objectId);
   System.out.println("Version label is now:" + doc.getVersionLabel());
}