for (int j = 1; j < clength; j = j + 2) {

        Node thisNode = nchild.item(j);

        String theString = null;
        if (thisNode != null && thisNode.getFirstChild() != null) {
            theString = thisNode.getFirstChild().getNodeValue();
        }

        if (theString != null) {
            String nodeName = thisNode.getNodeName();
            // rest of your code