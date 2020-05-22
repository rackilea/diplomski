try
    {
    DocumentBuilderFactory docBuild = DocumentBuilderFactory.newInstance();
    DocumentBuilder docBuilder = docBuild.newDocumentBuilder();
    Document doc = docBuilder.parse(new File("D:\\users\\Popa Andrei\\Java Workspace\\YearForecast\\forecast.xml"));
    NodeList monthNodes = doc.getElementsByTagName("month");
    // monthNodes.

    XPath xPath = XPathFactory.newInstance().newXPath();

    for (int i = 0; i < monthNodes.getLength(); i++) {
        StringBuilder pathBuilder = new StringBuilder();
        pathBuilder.append("/Forecast/year/month[@name=");
        pathBuilder.append("'");
        Element monthNode = (Element) monthNodes.item(i);
        String month = monthNode.getAttribute("name");
        pathBuilder.append(month);
        pathBuilder.append("']/day");

        NodeList monthWiseNodes = (NodeList) xPath.evaluate(pathBuilder.toString(), doc.getDocumentElement(),
                XPathConstants.NODESET);


        System.out.println(month+":\n");

        for(int j = 0 ;j<monthWiseNodes.getLength();j++)
        {
            Node firstDay = monthWiseNodes.item(j);

            if(firstDay.getNodeType() == Node.ELEMENT_NODE)
            {
                Element firstDayElement = (Element)firstDay;

                System.out.println("\tDay:"+firstDayElement.getElementsByTagName("currentday").item(0).getTextContent());

                System.out.println("\tDate:"+firstDayElement.getElementsByTagName("date").item(0).getTextContent());

                System.out.println("\tTemperature:"+firstDayElement.getElementsByTagName("temperature").item(0).getTextContent()+" degrees");

                System.out.println("\tWeather:"+firstDayElement.getElementsByTagName("weather").item(0).getTextContent());

                System.out.println("\tHumidity:"+firstDayElement.getElementsByTagName("humidity").item(0).getTextContent()+"%\n");
            }
        }
    }

}catch (SAXParseException err) {
    System.out.println ("** Parsing error" + ", line " 
         + err.getLineNumber () + ", uri " + err.getSystemId ());
    System.out.println(" " + err.getMessage ());

    }catch (SAXException e) {
    Exception x = e.getException ();
    ((x == null) ? e : x).printStackTrace ();

    }catch (Throwable t) {
    t.printStackTrace ();
    }
}