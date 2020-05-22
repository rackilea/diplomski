for (int i = 0; i < nodeList.getLength(); i++) {
    Node n = nodeList.item(i);
    JSONObject xmlJSONObj = XML.toJSONObject(toString(n));
    String jsonPrettyPrintString = xmlJSONObj.toString(1);
    System.out.println(jsonPrettyPrintString);
}