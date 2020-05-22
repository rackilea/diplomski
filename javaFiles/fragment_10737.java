public void getXMLData() throws Exception {
        File stocks = new File("PhillPlugin.xml");
        BufferedInputStream in = new BufferedInputStream(new FileInputStream(stocks));
        StringBuilder sb = new StringBuilder();
        int cp;
        while ((cp = in.read()) != -1) {
            sb.append((char) cp);
            String t = sb.toString();
            if (t.contains("</AttributeValuePair>")) {
                String test = sb.toString();
                String test1p[] = test.split("<value>|</value>");
                tempurlGen = test1p[1];
                break;
            }
        }

        sb = new StringBuilder();
        while ((cp = in.read()) != -1) {

            sb.append((char) cp);
            String t = sb.toString();
            if (t.contains("</AttributeValuePair>")) {
                String test = sb.toString();
                String test1p[] = test.split("<value>|</value>");
                tempurlVal = test1p[1];
                break;
            }

        }
    }