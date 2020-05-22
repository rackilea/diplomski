XMLInputFactory inFactory = XMLInputFactory.newInstance();
    XMLEventReader eventReader = inFactory.createXMLEventReader(new FileInputStream("1.xml"));
    XMLOutputFactory factory = XMLOutputFactory.newInstance();
    XMLEventWriter writer = factory.createXMLEventWriter(new FileWriter(file));
    XMLEventFactory eventFactory = XMLEventFactory.newInstance();
    while (eventReader.hasNext()) {
        XMLEvent event = eventReader.nextEvent();
        writer.add(event);
        if (event.getEventType() == XMLEvent.START_ELEMENT) {
            if (event.asStartElement().getName().toString().equalsIgnoreCase("book")) {
                writer.add(eventFactory.createStartElement("", null, "index"));
                writer.add(eventFactory.createEndElement("", null, "index"));
            }
        }
    }
    writer.close();