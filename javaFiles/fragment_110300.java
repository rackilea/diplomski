NodeList lstNm = lstNmElmnt.getChildNodes();
 if (lstNm.getLength() > 0) {
    System.out.println("Last Tag : " + ((Node)lstNm.item(0)).getNodeValue());
 } else {
     System.out.println("No content");
 }