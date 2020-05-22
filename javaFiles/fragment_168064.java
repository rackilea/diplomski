InputStream initialStream = null;
        OutputStream outStream = null;
        try {
            initialStream = this.getClass().getClassLoader()
                    .getResourceAsStream("config/Config.xml");
            byte[] buffer = new byte[initialStream.available()];
            initialStream.read(buffer);

            File file = File.createTempFile("ConfigTemp", ".xml");
            file.deleteOnExit();

            outStream = new FileOutputStream(file);
            outStream.write(buffer);

            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(file);
            doc.getDocumentElement().normalize();
            System.out.println("Root element :"
                    + doc.getDocumentElement().getNodeName());
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e1) {
            e1.printStackTrace();
        } finally {
            try {
                initialStream.close();
                outStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }