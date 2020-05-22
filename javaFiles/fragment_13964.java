final Diff d = new Diff(result, correct);
    d.overrideDifferenceListener(new DifferenceListener() {

        public int differenceFound(Difference difference) {

            final Node controlNode = difference.getControlNodeDetail().getNode();
            final Node testNode = difference.getTestNodeDetail().getNode();
            if (difference.getId() == DifferenceConstants.ATTR_VALUE_ID
                && isXSIType(controlNode) && isXSIType(testNode)) {
                if (getNameSpaceFromPrefix(controlNode).compareTo(getNameSpaceFromPrefix(testNode)) != 0) {
                    return RETURN_ACCEPT_DIFFERENCE;
                }
                String withoutPrefixControl = getNameWithoutPrefix(controlNode);
                String withoutPrefixTest = getNameWithoutPrefix(testNode);

                if (withoutPrefixControl.compareTo(withoutPrefixTest) == 0) {
                    return RETURN_IGNORE_DIFFERENCE_NODES_IDENTICAL;
                }
            }
            return RETURN_ACCEPT_DIFFERENCE;
        }

        boolean isXSIType(org.w3c.dom.Node node) {
            return node.getNodeType() == Node.ATTRIBUTE_NODE &&
                node.getLocalName().compareTo("type") == 0 &&
                node.getNamespaceURI() == "http://www.w3.org/2001/XMLSchema-instance";
        }

        private String getNameSpaceFromPrefix(Node node) {
            final int beginIndex = node.getNodeValue().indexOf(":");
            if (beginIndex == -1) {
                return "";
            }
            return node.lookupNamespaceURI(node.getNodeValue().substring(0, beginIndex));
        }

        private String getNameWithoutPrefix(Node controlNode) {
            final int beginIndex = controlNode.getNodeValue().indexOf(":");
            if (beginIndex == -1) {
                return controlNode.getNodeValue();
            }
            return controlNode.getNodeValue().substring(beginIndex);
        }

        public void skippedComparison(org.w3c.dom.Node node, org.w3c.dom.Node node1) {

        }
    });