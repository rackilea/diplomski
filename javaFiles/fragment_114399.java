String nodeName = node.getNodeName();
ValSetter setter = setterForName.get(nodeName.toLowerCase());
if (setter != null) {
    String val = extractOptionalPropertyName(node.getNodeValue(), propFileLocation);
    setter.set(retryLogic, val);
} else {
    // report an error
}