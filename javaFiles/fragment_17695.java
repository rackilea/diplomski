for (int k=0; k<fillsList.getLength();k++){//donem voltes als fills de list.
    Node fillList = fillsList.item(k);
    if (fillList instanceof Element) {
        Element elementList = (Element) fillList;
        if(elementList.getNodeType() == Element.ELEMENT_NODE) {
            if (elementList.getNodeName().equals("filter")){
               System.out.println("Filter!!!");
            } else if (elementList.getNodeName().equals("option")){
               System.out.println("item!!!");
            }
        }
    }
}