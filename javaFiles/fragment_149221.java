DocumentBuilderFactory factory = xmlFactories.newDocumentBuilderFactory();
factory.setNamespaceAware(true);
factory.setValidating(false);
DocumentBuilder documentBuilder = factory.newDocumentBuilder();
documentBuilder.setEntityResolver(new EntityManager());

......

public class EntityManager implements EntityResolver {
  public InputSource resolveEntity(String publicId, String systemId) throws SAXException, IOException {
      /* code goes here to return contents of DTD */
  }

}