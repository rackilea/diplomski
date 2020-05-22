public void downloadLibrary()
    {
        System.out.println("Start downloading libraries from server...");
        try
        {
            URL resourceUrl = new URL("http://www.example.com/libraries.xml");
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();

            // change here
            URLConnection con = resourceUrl.openConnection();
            BufferedReader bfr = new BufferedReader(new InputStreamReader(con.getInputStream()));

            String tempDoc = "";
            String tempStr;
            while (tempStr = bfr.readLine()) != null) {
                tempDoc += tempStr + System.getProperty("line.separator");
            }

            Document doc = db.parse(tempDoc);

            NodeList nodeLst = doc.getElementsByTagName("Contents");
            for (int i = 0; i < nodeLst.getLength(); i++)
            {
                Node node = nodeLst.item(i);

                if (node.getNodeType() == 1)
                {
                    Element element = (Element)node;
                    String key = element.getElementsByTagName("Key").item(0).getChildNodes().item(0).getNodeValue();
                    File f = new File(launcher.getWorkingDirectory(), key);
                    downloadFile("http://www.example.com/" + key, f, "libraries");
                }
            }
        }
        catch(Exception e)
        {
            System.out.println("Error was found when trying to download libraries file " + e);
        }

    }