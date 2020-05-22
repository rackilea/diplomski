box.ready(new Function() {

            @Override
            public Object call(Object arg) {

            NodeList<Node> children =box.getElement().getChildNodes();

            for (int i = 0; i < children.getLength(); i++) {
            Node node = children.getItem(i);                      
            if (node.getNodeName().equals("PAPER-INPUT-CONTAINER")) {
            Element paperContainerElement = (Element) node;
            paperContainerElement.setAttribute("always-float-label", "true");
            break;                
                                  }               
                              }

            return null;
            }

        });