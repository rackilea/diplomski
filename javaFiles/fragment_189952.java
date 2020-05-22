ClassLoader cl = Monopoly.class.getClassLoader();
InputStream xml =
 cl.getResourceAsStream("resources/monopoly_config.xml");
JAXBContext jc = JAXBContext.newInstance(Monopoly.class);
Unmarshaller unmarshaller = jc.createUnmarshaller();
Monopoly monopoly = (Monopoly) unmarshaller.unmarshal(xml);