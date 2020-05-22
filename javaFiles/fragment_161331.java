File f = new File("test.xml");
        XPathFactory factory = XPathFactory.newInstance();
        XPath xpath = factory.newXPath();
        InputSource src = new InputSource(new FileInputStream(f));
        Object result = xpath.evaluate("//codes[@class='class2']/code/@code",src,XPathConstants.NODESET);
        NodeList lst = (NodeList)result;

        List<String> codeList = new ArrayList<String>();
        for(int idx=0; idx<lst.getLength(); idx++){
            codeList.add(lst.item(idx).getNodeValue());
        }
        if(codeList.contains("123")){
            System.out.println("123");
        }

        if(codeList.contains("123") && codeList.contains("456")){
            System.out.println("123 and 456");
        }