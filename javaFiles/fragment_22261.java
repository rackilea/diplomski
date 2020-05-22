Map<String, Element> elementsMap= new HashMap();
    for(int i = 1; i<=7 ; i++){ //7 is an arbitrary num for demo

        Element element = doc.createElement("include");
        String elementName = "elementInclude"+ i;
        elementsMap.put(elementName, element);
    }