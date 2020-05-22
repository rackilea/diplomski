Document doc = DocumentBuilderFactory.newInstance()
            .newDocumentBuilder()
            .parse("Solve.xml");

    XPath xp = XPathFactory.newInstance().newXPath();

    NodeList list = (NodeList) xp.evaluate("//user1/user2[@id = 'a1']", doc, XPathConstants.NODESET);
    for(int i=0; i < list.getLength(); ++i) {
        Element user2 =  (Element) list.item(i);
        System.out.println("user2 = " + user2.getTextContent());
    }