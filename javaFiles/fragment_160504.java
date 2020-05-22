// Getting VIN of Detail
 if (element.getElementsByTagName("VIN").getLength() > 0) {
        childNode = element.getElementsByTagName("VIN").item(0); //Get all the elements one by one
        String VIN = childNode.getFirstChild().getNodeValue();

    }