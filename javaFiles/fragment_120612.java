public void wypisanie() throws Exception {
        URL url = new URL("https://www.nbp.pl/kursy/xml/c001z020102.xml");
        System.out.println("1");
        URLConnection urlConnection = url.openConnection();
        System.out.println("2");
        InputStream in = new BufferedInputStream(urlConnection.getInputStream());
        System.out.println("3");

        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

        dbf.setValidating(false);
        dbf.setNamespaceAware(true);
        dbf.setFeature("http://xml.org/sax/features/namespaces", false);
        dbf.setFeature("http://xml.org/sax/features/validation", false);
        dbf.setFeature("http://apache.org/xml/features/nonvalidating/load-dtd-grammar", false);
        dbf.setFeature("http://apache.org/xml/features/nonvalidating/load-external-dtd", false);

        System.out.println("4");
        DocumentBuilder dBuilder = dbf.newDocumentBuilder();
        System.out.println("5");
        Document doc1 = dBuilder.parse(in);
        System.out.println("6");
        Element element1 = doc1.getDocumentElement();
        System.out.println("7");
        NodeList nodes1 = element1.getChildNodes();
        System.out.println("8");
        for (int i = 0; i < nodes1.getLength(); i++) {
            if ("pozycja".equals(nodes1.item(i).getNodeName())) {
                System.out.println("" + nodes1.item(i).getTextContent());
            }
        }
    }