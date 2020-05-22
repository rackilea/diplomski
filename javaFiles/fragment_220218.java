public void updateParameters(int index, int row, int column,
            String columnName, Object data) throws Exception {

        int objTypeIndex = index + 1;

        File xml = new File("xmlFiles/CoreDatamodel.xml");

        try {
            XMLOutputter xmlOut = new XMLOutputter();
            org.jdom2.Document doc = new SAXBuilder().build(xml);
            Namespace ns = Namespace.getNamespace("http://www.bombardier.com");
            org.jdom2.Element rootNode = doc.getRootElement();
            org.jdom2.Element typeContent = rootNode.getChildren().get(
                    objTypeIndex);

            List<Element> list = typeContent.getChildren("param", ns);

            if (list.size() > 0) {
                Element element = list.get(row);
                List paramChilds = element.getChildren(columnName, ns);

                Element node = (Element) paramChilds.get(0);
                node.setText(data.toString());
                System.out.println(node.getText());
                xmlOut.setFormat(Format.getPrettyFormat());
                xmlOut.output(doc, new FileWriter("xmlFiles/CoreDatamodel.xml"));

            }

        } catch (IOException io) {
            System.out.println(io.getMessage());
        } catch (JDOMException jdomex) {
            System.out.println(jdomex.getMessage());
        }

    }