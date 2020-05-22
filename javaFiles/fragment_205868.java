for (int j = 1; j < clength; j = j + 2) {

                Node thisNode = nchild.item(j);
                String theString = null;
                String nodeName = thisNode.getNodeName();

                theString = nchild.item(j).getFirstChild().getNodeValue();
                if (theString != null) {
                       // rest of your code