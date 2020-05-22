public class XSLMagic implements URIResolver {

public void DoXSLTransform(final File xslDoc, final File xmlDoc, final File resultDoc) {
    // Create the factory...
    TransformerFactory tf = TransformerFactory.newInstance();

    tf.setURIResolver(this); // WORKS - Set the URIResolver to the factory instead, 'resolve' function now called as expected.

    // Create the transformer object from 
    Transformer tr = tf.newTransformer(new StreamSource(xslDoc));       

    tr.transform(new StreamSource(xmlDoc), new StreamResult(resultDoc));
}

@Override
public Source resolve(String href, String base) throws TransformerException {
    System.out.print("resolve: " + href + " " + base + "\n");
    return null;
}
}