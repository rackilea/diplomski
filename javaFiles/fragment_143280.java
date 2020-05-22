public static void main(String[] args) 
    {
        String xmlFile = "your xml file"  // read your xml file to string

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try
        {
            DocumentBuilder builder = factory.newDocumentBuilder();
            InputSource is = new InputSource(new StringReader(xmlFile));
            Document document = builder.parse(is);

            List<Person> listOfPersons = new ArrayList<Person>();
            NodeList nodeList = document.getDocumentElement().getChildNodes();

            for (int i = 0; i < nodeList.getLength(); i++)
            {
                Node node = nodeList.item(i);

                if (node.getNodeType() == Node.ELEMENT_NODE)
                {
                    Element elem = (Element) node;
                    String firstNameText = "";
                    if (elem.getElementsByTagName("FirstName").item(0).getChildNodes().item(0) != null)
                    {
                        firstNameText = elem.getElementsByTagName("FirstName").item(0).getChildNodes().item(0).getNodeValue();
                    }
                    String lastNameText = "";
                    if (elem.getElementsByTagName("LastName").item(0).getChildNodes().item(0) != null)
                    {
                        lastNameText = elem.getElementsByTagName("LastName").item(0).getChildNodes().item(0).getNodeValue();
                    }
                    String ageText = "";
                    if (elem.getElementsByTagName("Age").item(0).getChildNodes().item(0) != null)
                    {
                        ageText = elem.getElementsByTagName("Age").item(0).getChildNodes().item(0).getTextContent();
                    }

                    List<FavoriteColors> listOfColors = new ArrayList<FavoriteColors>();
                    NodeList nl = elem.getElementsByTagName("FavoriteColors").item(0).getChildNodes();

                    for (int j = 0; j < nl.getLength(); j++)
                    {
                        Node n = nl.item(j);

                        if (n.getNodeType() == Node.ELEMENT_NODE)
                        {
                            Element e = (Element) n;
                            String colorName = "";
                            if (e.getElementsByTagName("ColorName").item(0).getChildNodes().item(0) != null)
                            {
                                colorName = e.getElementsByTagName("ColorName").item(0).getChildNodes().item(0).getNodeValue();
                            }
                            boolean isFavorite = false;
                            if (e.getElementsByTagName("IsFavorite").item(0).getChildNodes().item(0).getNodeValue() != null)
                            {
                                isFavorite = Boolean.parseBoolean(e.getElementsByTagName("IsFavorite").item(0).getChildNodes().item(0).getNodeValue());
                            }

                            listOfColors.add(new FavoriteColors(colorName, isFavorite));
                        }
                    }

                    listOfPersons.add(new Person(firstNameText, lastNameText, ageText, listOfColors));
                }
            }
        } 
        catch (ParserConfigurationException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SAXException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }