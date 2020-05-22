public void fetchTypesXml(XMLResponse listener) {
    ...

    // when you finished to request and parse all the data, call the function inside the listener
    listener.sendXMLData(adresse, telephone, fax, website ...);

    }