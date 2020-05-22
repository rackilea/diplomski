Document document = null;
try {
  document = parentFolder.createDocument(props, contentStream, null);
  System.out.println("Created new document: " + document.getId());
} catch (CmisContentAlreadyExistsException ccaee) {
  document = (Document) cmisSession.getObjectByPath(parentFolder.getPath() + "/" + fileName);
  System.out.println("Document already exists: " + fileName);
}
return document;