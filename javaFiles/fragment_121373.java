private String findParentName(String node) {

        Node parentNode;
        String parentName;
        String nodeName = node;

        try {
            StringBuilder xpathIDExp = new StringBuilder();
            xpathIDExp.append("//g[@id = '").append(nodeName).append("']/../@id");

            XPathFactory xpf = XPathFactory.newInstance();
            XPath xpath = xpf.newXPath();
            XPathExpression expression = xpath.compile(xpathIDExp.toString());

            parentNode = (Node)expression.evaluate(svgDoc, XPathConstants.NODE);
            parentName = parentNode.getNodeValue();

            if (!parentName.isEmpty()) {
                StringBuilder st = new StringBuilder();

                st.append("'").append(parentName).append(" > ").append(nodeName).append("'");
                nodeName = st.toString();
            }
        } catch (XPathExpressionException ex) {
            Logger.getLogger(SVGParser.class.getName()).log(Level.SEVERE, null, ex);
        }

        return nodeName;
    }