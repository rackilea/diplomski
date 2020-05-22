private static String getTagValue(String tag, Element eElement) {
    NodeList nlList = eElement.getElementsByTagName(tag).item(0).getChildNodes();
    Node nValue = (Node) nlList.item(0);
    if(nValue == null) 
        return null;
    return nValue.getNodeValue();
}

String salary = getTagValue("Department", eElement);
if(salary != null) {
    System.out.println("Salary : " + getTagValue("Department", eElement));
}