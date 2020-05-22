public Object xmlToJava(Object pCurrentObject, String pXml, String pRowset, String pRow) {
    InputStream  instr = null;
    JAXBContext  jaxbContext = null;
    Unmarshaller jaxbUnmarshaller = null;

    String xmlHeader = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n";
    String xmlReturn = null;
    Class  objectClass = pCurrentObject.getClass();
    try {
        xmlReturn =
            pXml.replaceFirst("ROWSET xmlns:xsi = " +
                              "\"http://www.w3.org/2001/XMLSchema-instance\"",
                              pRowset); //"invTrxLines");

        xmlReturn = xmlHeader.concat(xmlReturn);
        xmlReturn = xmlReturn.replaceAll("ROWSET", pRowset); //"invTrxLines");

        if (null != pRow && !pRow.isEmpty()) {
            xmlReturn = xmlReturn.replaceAll("ROW", pRow); //invTrxLine);
        } else { //Remove Row tags in case of single object
            xmlReturn = xmlReturn.replaceAll("<ROW>", "");
            xmlReturn = xmlReturn.replaceAll("</ROW>", "");
        }

        xmlReturn = xmlReturn.replaceAll(" xsi:nil = \"true\"", "");
        instr = new ByteArrayInputStream(xmlReturn.getBytes());
        jaxbContext = JAXBContext.newInstance(objectClass); //InvTrxHead.class);
        jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        pCurrentObject = jaxbUnmarshaller.unmarshal(instr);
    } catch (Exception e) {
        // TODO: Add catch code
        e.printStackTrace();
    }
    return pCurrentObject;
}