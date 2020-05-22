NodeList connectionsList = doc.getElementsByTagName("CONNECTIONS");
    for (int j = 0; j < connectionsList.getLength(); j++) {
        if (connectionsList.item(j).getNodeType() == Node.TEXT_NODE) {
            continue;
        }

        String entryName = connectionsList.item(j).getNodeName();
        if (!entryName.equals("CONNECTIONS")) {
            System.err.println("Unexpected node found: " + entryName);
            return;
        }

        // Get some named nodes
        Node elem = (Element) connectionsList.item(j).getChildNodes(); // list of CONNECTION ELEMENTS
        List<String> facilities = new ArrayList<String>();
        for(int i = 0 ; i< elem.getChildNodes().getLength() ;i++){
            Node subElem =  elem.getChildNodes().item(i); //CONNECTION ELEMENT
            String connectionName ="";
            String connectionDist = "";
            for(int k = 0 ; k< subElem.getChildNodes().getLength(); k++){
                Node connectionElem = subElem.getChildNodes().item(k);
                if("NAME".equals(connectionElem.getNodeName())){
                    connectionName = connectionElem.getTextContent();
                }
                else if("DISTANCE".equals(connectionElem.getNodeName())){
                    connectionDist = connectionElem.getTextContent();
                }
                if(!connectionDist.equals("") && !connectionName.equals("")) {
                    facilities.add(connectionName + " , " + connectionDist);
                    connectionDist ="";
                    connectionName = "";
                }
            }

        }
        System.out.println("Facility: "+doc.getElementsByTagName("FACILITY").item(j).getTextContent() +"  Direct Links: "+facilities);
    }