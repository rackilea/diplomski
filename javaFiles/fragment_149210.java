Document doc = (Document) docBuilder.parse(new URL("http://api.irishrail.ie/realtime/realtime.asmx/getStationDataByNameXML?StationDesc=" + dstation).openStream());
doc.getDocumentElement().normalize();
NodeList trains = doc.getElementsByTagName("objStationData");
for(int i = 0; i<trains.getLength(); i++){
    Element objStationDataElement = (Element)trains.item(i);
    Element directionElement = objStationDataElement.getElementsByTagName("Direction").item(0);
    if(directionElement.getTextContent().trim().equals("Northbound")){
        Element destinationElement = (Element)objStationDataElement.getElementsByTagName("Destination").item(0);
        System.out.println(destinationElement.getTextContent().trim());
    }
}