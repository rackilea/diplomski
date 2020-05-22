String nodeName = node.getNodeName();
if (nodeName.equalsIgnoreCase("maximumRedeliveries")) {
    retryLogic.setMaximumRedeliveries(extractOptionalPropertyName(node.getNodeValue(), propFileLocation));
} else if (nodeName.equalsIgnoreCase("asyncDelayedRedelivery")) {
    retryLogic.setAsyncDelayedRedelivery(extractOptionalPropertyName(node.getNodeValue(), propFileLocation));
} ... // and so on