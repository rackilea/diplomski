public void getTemperature() throws SAXException, IOException, ParserConfigurationException {

        String xml = "<current>\r\n" + 
        "<city id=\"2643743\" name=\"London\">\r\n" + 
        "<coord lon=\"-0.13\" lat=\"51.51\"/>\r\n" + 
        "<country>GB</country>\r\n" + 
        "<sun rise=\"2017-01-30T07:40:36\" set=\"2017-01-30T16:47:56\"/>\r\n" + 
        "</city>\r\n" + 
        "<temperature value=\"280.15\" min=\"278.15\" max=\"281.15\" unit=\"kelvin\"/>\r\n" + 
        "<humidity value=\"81\" unit=\"%\"/>\r\n" + 
        "<pressure value=\"1012\" unit=\"hPa\"/>\r\n" + 
        "<wind>\r\n" + 
        "<speed value=\"4.6\" name=\"Gentle Breeze\"/>\r\n" + 
        "<gusts/>\r\n" + 
        "<direction value=\"90\" code=\"E\" name=\"East\"/>\r\n" + 
        "</wind>\r\n" + 
        "<clouds value=\"90\" name=\"overcast clouds\"/>\r\n" + 
        "<visibility value=\"10000\"/>\r\n" + 
        "<precipitation mode=\"no\"/>\r\n" + 
        "<weather number=\"701\" value=\"mist\" icon=\"50d\"/>\r\n" + 
        "<lastupdate value=\"2017-01-30T15:50:00\"/>\r\n" + 
        "</current>";


        Document doc = DocumentBuilderFactory
                .newInstance()
                .newDocumentBuilder()
                .parse(new InputSource (new StringReader(xml)));

        NodeList errNodes=doc.getElementsByTagName("current");
        if(errNodes.getLength()>0){
            Element err=(Element) errNodes.item(0);
            NodeList temps = err.getElementsByTagName("temperature");
            Node temp = temps.item(0);
            NamedNodeMap attrs = temp.getAttributes();
            Node val = attrs.getNamedItem("value");
            String strValue = val.getNodeValue();
            System.out.println(strValue);
        }
}