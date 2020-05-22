DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document dom = dBuilder.parse(new ByteArrayInputStream(S.getBytes()));
        NodeList collected_objects = dom.getElementsByTagName("object");
        System.out.println("Number of collected objects are "
                + collected_objects.getLength());

        for (int i = 0; i < collected_objects.getLength(); i++) {

            Node aNode = collected_objects.item(i);
            // get children of "objects"
            NodeList refNodes = aNode.getChildNodes();

            System.out.println("# of chidren are " + refNodes.getLength());

            //
            for (int x = 0; x < refNodes.getLength(); x++) {
                Node n = refNodes.item(x);
                System.out.println(n.getNodeType() + " = " + n.getNodeName() + "/" + n.getNodeValue());
            }

            // print attributes of "objects"

            NamedNodeMap attributes = aNode.getAttributes();
            for (int a = 0; a < attributes.getLength(); a++) {
                Node theAttribute = attributes.item(a);
                System.out.println(theAttribute.getNodeName() + "="
                        + theAttribute.getNodeValue());

            }

        }