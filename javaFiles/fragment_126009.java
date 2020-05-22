NamedNodeMap map = element.getAttributes();
for (int iattr=0; iattr<map.getLength(); iattr++) {
   Attr attr = (Attr)map.item(iattr);
   if (attr.getNamespaceURI() != null) {
      System.out.println("Attr " + attr.getName() + " -  " + attr.getNamespaceURI());
   }
}