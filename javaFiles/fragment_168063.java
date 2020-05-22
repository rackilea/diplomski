XPath xpath = XPathFactory.newInstance().newXPath();
    String expression = "/DNREvents/DEvent/event";
    InputSource inputSource = new InputSource(new BufferedReader(new FileReader("/data/test/test.xml")));
    NodeList eventList = (NodeList) xpath.evaluate(expression, inputSource, XPathConstants.NODESET);

    for (int i=0; i< eventList.getLength(); i++) {
        Node eventNode = eventList.item(i);

        String eid = xpath.evaluate("@eid", eventNode);
        String value = xpath.evaluate("./text()", eventNode);
        System.out.println("EID: " + eid + ", Value: " + value + "\n");
    }