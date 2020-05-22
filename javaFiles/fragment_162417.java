NodeList customers = (NodeList)expr.evaluate(doc, XPathConstants.NODESET); 


  for (int i = 0; i < customers.getLength(); i++) {


        XPathExpression expr1 = xpath.compile("address");
        Node address = (Node)expr1.evaluate(customers.item(i),XPathConstants.NODE);
        System.out.println(address.getTextContent());


  }