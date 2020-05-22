InputStream is = new FileInputStream("...");
XMLInputFactory xif = XMLInputFactory.newFactory();
XMLStreamReader xsr = xif.createXMLStreamReader(is);
while (xsr.hasNext()) {
  if (xsr.next() == XMLStreamConstants.START_ELEMENT
      && xsr.getLocalName().equals("dad")) {

    if (xsr.next() == XMLStreamConstants.CHARACTERS)
      System.out.println(xsr.getText());
  }
}