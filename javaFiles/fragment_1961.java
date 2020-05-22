public static void replaceGroupTags(File input, File output, String tag, String replacement) {
             Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new InputSource(inputFile));

            XPath xpath = XPathFactory.newInstance().newXPath();
            NodeList nodes = (NodeList)xpath.evaluate("//SomeNode/" + tag, doc, XPathConstants.NODESET);

            // replace all occurences
            for (int i = 0; i < nodes.getLength(); i++) {
              nodes.item(i).setTextContent(replacement);
            }

            // save result to the file 
            Transformer xformer = TransformerFactory.newInstance().newTransformer();
            xformer.transform(new DOMSource(doc), new StreamResult(output);
    }