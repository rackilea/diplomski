class MyURIResolver implements URIResolver {
@Override
public Source resolve(String href, String base) throws TransformerException {
  try {
    ClassLoader cl = this.getClass().getClassLoader();
    java.io.InputStream in = cl.getResourceAsStream("xsl/" + href);
    InputSource xslInputSource = new InputSource(in);
    Document xslDoc = dBuilder.parse(xslInputSource);
    DOMSource xslDomSource = new DOMSource(xslDoc);
    xslDomSource.setSystemId("xsl/" + href);
    return xslDomSource;
 } catch (...