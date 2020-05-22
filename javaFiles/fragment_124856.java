String expression ="//include[@template]";                                                                          
NodeList nodeList = (NodeList) xPath.compile(expression).evaluate(xmlDocument, XPathConstants.NODESET);

for(int i=0; i<nodeList.getLength(); i++){
    NodeList childList = nodeList.item(i).getChildNodes();
    for(int k=0; k<childList.getLength(); k++){         
        Node child = childList.item(k);
        if(child instanceof Element){
            Element elem = (Element)child;
            if("param".equals(elem.getLocalName())){
                String name = elem.getAttribute("name");
                String value = elem.getAttribute("value");
                System.out.println("Name: "+name+" Value: "+value);
            }
        }
    }
}