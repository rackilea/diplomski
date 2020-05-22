try{    
        MultipartFile newFile=multiPartRequest.getFile("newFileUpload");
        InputStream is = new newFile.getInputStream();
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();                 
        Document doc = dBuilder.parse(is);
      } catch (SAXException | IOException | ParserConfigurationException ex) {
        Logger.getLogger(JavaApplication4.class.getName()).log(Level.SEVERE, null, ex);
    }