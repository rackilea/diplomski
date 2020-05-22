DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
DocumentBuilder builder = factory.newDocumentBuilder();

Document doc = builder.parse("input.xml");

NodeList labTestList = doc.getElementsByTagName("LabTest");
for (int i = 0; i < labTestList.getLength(); ++i)
{
    Element labTest = (Element) labTestList.item(i);
    String labTestType = labTest.getAttribute("type");

    NodeList valueList = labTest.getElementsByTagName("value");
    for (int j = 0; j < valueList.getLength(); ++j)
    {
        Element value = (Element) valueList.item(j);
        String valueType = value.getAttribute("type");

        NodeList conditionList = value.getElementsByTagName("condition");
        for (int k = 0; k < conditionList.getLength(); ++k)
        {
            Element condition = (Element) conditionList.item(k);
            String conditionText = condition.getFirstChild().getNodeValue();
        }
    }
}