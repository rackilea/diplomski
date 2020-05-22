BufferedReader br = ...
XMLInputFactory inputFactory = XMLInputFactory.newInstance();
Pattern startOfXml = Pattern.compile("<\\?xml.*\\?>");
String line;
while (null != (line = br.readLine()) {
    if (startOfXml.matcher(line).matches()) {
        XMLEventReader xr = inputFactory.createXMLEventFactory(br);
        XMLEvent event;
        while (!(event = xr.nextEvent()).isEndDocument()) {
            // do whatever you want with the event
        }
    } else {
        // do whatever you want with the plain-text
    }
}