DocumentBuilderFactory df = DocumentBuilderFactory.newInstance();

    try
    {
        DocumentBuilder db = df.newDocumentBuilder();
        InputStream is = new ByteArrayInputStream(response.getContent().getBytes("UTF-8"));
        org.w3c.dom.Document doc = db.parse(is);
        NodeList links = doc.getElementsByTagName("class");
          for(int i=0; i< links.getLength(); i++)
          {
             Node link = links.item(i);
             System.out.println(link.getTextContent());
          }
    }
    catch(Exception ex)
    {
    }