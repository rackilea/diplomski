NodeList feeds = doc.getElementsByTagName("entities");
    for (int i = 0; i < feeds.getLength(); i++) {
        Node mainNode = feeds.item(i);
        if (mainNode.getNodeType() == Node.ELEMENT_NODE) {
            Element firstElement = (Element) mainNode;
            System.out.println("First element "
                    + firstElement.getTagName());
            NodeList forumidNameList = firstElement
                    .getElementsByTagName("entity");

            for (int j = 0; j < forumidNameList.getLength(); ++j) {
                Element value = (Element) forumidNameList.item(j);

                NodeList conditionList = value
                        .getElementsByTagName("type");
                for (int k = 0; k < conditionList.getLength(); ++k) {
                    Element condition = (Element) conditionList.item(k);
                    if (condition.getParentNode().getNodeName()
                            .equals("entity")) {
                        String conditionText = condition
                                .getFirstChild().getNodeValue();
                        System.out.println("type " + conditionText);

                    }
                }
                NodeList conditionList1 = value
                        .getElementsByTagName("relevance");
                for (int k = 0; k < conditionList1.getLength(); ++k) {
                    Element condition = (Element) conditionList1
                            .item(k);
                    String conditionText = condition.getFirstChild()
                            .getNodeValue();
                    System.out.println("relevance " + conditionText);
                }
                NodeList conditionList2 = value
                        .getElementsByTagName("sentiment");
                for (int k = 0; k < conditionList2.getLength(); ++k) {
                    Element condition = (Element) conditionList2
                            .item(k);
                    for (int l = 0; l < condition.getChildNodes()
                            .getLength(); ++l) {
                        Element condition2 = (Element) condition
                                .getChildNodes().item(l);
                        String conditionText = condition2
                                .getFirstChild().getNodeValue();
                        System.out
                                .println("sentiment " + conditionText);
                    }
                }
                NodeList conditionList3 = value
                        .getElementsByTagName("count");
                for (int k = 0; k < conditionList3.getLength(); ++k) {
                    Element condition = (Element) conditionList3
                            .item(k);
                    String conditionText = condition.getFirstChild()
                            .getNodeValue();
                    System.out.println("count " + conditionText);
                }
                NodeList conditionList4 = value
                        .getElementsByTagName("text");
                for (int k = 0; k < conditionList4.getLength(); ++k) {
                    Element condition = (Element) conditionList4
                            .item(k);
                    String conditionText = condition.getFirstChild()
                            .getNodeValue();
                    System.out.println("text " + conditionText);
                }
            }
        }
    }
output
----------------
First element entities
type FieldTerminology
relevance 0.732316
sentiment negative
sentiment -0.351864
count 2
text financial crisis
type Company
relevance 0.496572
sentiment neutral
count 1
text Goldman Sachs