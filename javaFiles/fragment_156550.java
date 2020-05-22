try {
                   dbf = DocumentBuilderFactory.newInstance();
                   db = dbf.newDocumentBuilder();
                   InputSource is = new InputSource(new ByteArrayInputStream(response.getBytes("UTF-8")));
                   document = db.parse(is);
                   System.out.println(document);//here we get null;
                       System.out.println(document.getNodeName());//here we get document;
                      for(int i =0 ; i<document.getChildNodes().getLength();i++)
                   System.out.println(document.getChildNodes().item(i).getChildNodes().item(i).getNodeName());
                }


    Output :

    [#document: null]
    document
    soap:Body