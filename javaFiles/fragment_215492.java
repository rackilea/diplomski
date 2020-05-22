Marshaller marshaller = jaxbContext.createMarshaller();
marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
marshaller.marshal(myObject, myFileTmp);

if (myFileTmp.exists() && myFileTmp.length() > 0) {
  myFile.delete();
  myFileTmp.renameTo(myFile);
}