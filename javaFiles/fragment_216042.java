XMLEventReader eventReader = factory.createXMLEventReader(in);
StringBuilder content = null;
while(eventReader.hasNext()) {
  XMLEvent event = eventReader.nextEvent();
  if(event.isStartElement()) {
    // other start element processing here
    content = new StringBuilder();
  } else if(event.isEndElement()) {
    if(content != null) {
      // this was a leaf element
      String leafText = content.toString();
      // do something with the leaf node
    } else {
      // not a leaf
    }
    // in all cases, discard content
    content = null;
  } else if(event.isCharacters()) {
    if(content != null) {
      content.append(event.asCharacters().getData());
    }
  }
  // other event types here
}