public void writeXmlFile(ArrayList<details> list) {

    try {

        DocumentBuilderFactory dFact = DocumentBuilderFactory.newInstance();
        DocumentBuilder build = dFact.newDocumentBuilder();
        Document doc = build.newDocument();

        Element root = doc.createElement("Studentinfo");
        doc.appendChild(root);

        Element Details = doc.createElement("Details");
        root.appendChild(Details);


        for (details dtl : list) {

            Element name = doc.createElement("Name");
            name.appendChild(doc.createTextNode(String.valueOf(dtl
                    .getName())));
            Details.appendChild(name);

            Element id = doc.createElement("ID");
            id.appendChild(doc.createTextNode(String.valueOf(dtl.getId())));
            Details.appendChild(id);

            Element mmi = doc.createElement("Age");
            mmi.appendChild(doc.createTextNode(String.valueOf(dtl.getAge())));
            Details.appendChild(mmi);

        }

        // Save the document to the disk file
        TransformerFactory tranFactory = TransformerFactory.newInstance();
        Transformer aTransformer = tranFactory.newTransformer();

        // format the XML nicely
        aTransformer.setOutputProperty(OutputKeys.ENCODING, "ISO-8859-1");

        aTransformer.setOutputProperty(
                "{http://xml.apache.org/xslt}indent-amount", "4");
        aTransformer.setOutputProperty(OutputKeys.INDENT, "yes");

        DOMSource source = new DOMSource(doc);
        try {
            // location and name of XML file you can change as per need
            FileWriter fos = new FileWriter("./ros.xml");
            StreamResult result = new StreamResult(fos);
            aTransformer.transform(source, result);

        } catch (IOException e) {

            e.printStackTrace();
        }

    } catch (TransformerException ex) {
        System.out.println("Error outputting document");

    } catch (ParserConfigurationException ex) {
        System.out.println("Error building document");
    }
}