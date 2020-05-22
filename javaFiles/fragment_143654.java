for (int i=0; i<nodeList.getLength(); i++) 
    {
        // Get element
        Element element = (Element)nodeList.item(i);
        final NodeList nodes = element.getChildNodes();
        if(nodes.getLength() == 1)
        {               
            System.out.println(element.getNodeName() + " " + element.getTextContent());
        }            
    }