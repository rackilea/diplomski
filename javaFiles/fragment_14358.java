public String getHighest(Document doc) {   
        NodeList list = doc.getElementsByTagName("output");
        String currentResult = null;
        int highestHit = 0;
        for (int i = 0; i < list.getLength(); i++) {
            int hits = Integer.parseInt(((Element) list.item(i)).getAttribute("hits"));
            if (hits > highestHit) {
                highestHit = hits;
                currentResult = list.item(i).getTextContent();
            }
         }
         return currentResult;
    }