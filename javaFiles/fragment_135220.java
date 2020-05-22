switch(eventType){

case (XMLEvent2.START_ELEMENT):
    currentElementName = xmlsr.getName().toString();
    logger.info("currentElementName: " + currentElementName);


    if("dad".equals(currentElementName) == true){
        logger.info("isStartElement: " + xmlsr.isStartElement());
        logger.info("Element BEGIN: " + currentElementName);
        xmlsr.skipElement();
    }


    case (XMLEvent2.ATTRIBUTE):
        int attributeCount = xmlsr.getAttributeCount(); 
        ...
        break;


}