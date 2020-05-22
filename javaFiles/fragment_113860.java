NodeList LineItemAttributeChildrenList = doc.getElementsByTagName("e");
    if (LineItemAttributeChildrenList != null && LineItemAttributeChildrenList.getLength() > 0) 
    {
        System.out.println("Inside if and checking length"+LineItemAttributeChildrenList.getLength());
        for (int i = 0; i < LineItemAttributeChildrenList.getLength(); i++) {
            System.out.println("i "+i);
            System.out.println("inside for");
            System.out.println("name=============="+LineItemAttributeChildrenList.item(i).getNodeName());
            System.out.println("value=============="+LineItemAttributeChildrenList.item(i).getTextContent());
        }
     }