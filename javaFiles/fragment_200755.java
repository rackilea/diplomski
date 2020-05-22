String xml = "<hello><world /></hello>";
    try {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();

        Document document0 = db.parse(new InputSource(new StringReader(xml)));
        Document document1 = db.newDocument();


        NodeList nodeList = document0.getDocumentElement().getChildNodes();
        document1.appendChild(document1.adoptNode(nodeList.item(0).cloneNode(true)));

        // Serialize the two documents to check that the copy was correct.
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        Transformer transformer = TransformerFactory.newInstance().newTransformer();
        transformer.transform(new DOMSource(document0), new StreamResult(output));
        System.out.println(output.toString("UTF-8"));

        output.reset();
        transformer.transform(new DOMSource(document1), new StreamResult(output));
        System.out.println(output.toString("UTF-8"));
    } catch (TransformerException e) {
    } catch (IOException e) {
    } catch (SAXException e) {
    } catch (ParserConfigurationException e) {
    }