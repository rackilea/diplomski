String locationNode = getFirstTextContent(document, "location");

if (locationNode.length() > 0) {
    String DEVICEID = getFirstTextContent(document, "deviceId");
    String[] LOCATION = getFirstTextContent(document, "location").split("\\/");
}