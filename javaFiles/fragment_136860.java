for (int i = 0; i < dataStreams.lenght(); i++) {
         Element dataStream = (Element) dataStreams.item(i);
         if (dataStream.getNodeType() == Element.ELEMENT_NODE) {
                     String title = dataStream.getAttributes()
                                              .getNamedItem("title").getTextContent();
         }
}