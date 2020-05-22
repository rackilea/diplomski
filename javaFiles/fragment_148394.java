<!-- language: java -->
@XmlRootElement
public class JaxbXml2MapAdapter extends XmlAdapter<Object, HashMap<String, String>> {

    public JaxbXml2MapAdapter() {
        super();
    }

    @Override
    public Object marshal(HashMap<String, String> map) throws Exception {
        // I wasn't using it for sending this out in the response. So
        // did not bother to implement marshaling.
        return null;
    }

    @Override
    public HashMap<String, String> unmarshal(Object rawRoot) throws Exception {
        final HashMap<String, String> map = new HashMap<String, String>();

        if (rawRoot == null || !(rawRoot instanceof Element)) {
            return map;
        }

        final Element  root     = (Element) rawRoot;
        final NodeList children = root.getChildNodes();

        if (children.getLength() == 0) {
            return map;
        }

        // TODO: Analyze if there is a better way of reading the nodes.
        // Currently we get null/empty node names, white space values etc.

        for (int index = 0; index < children.getLength(); ++index) {
            final Node   child = children.item(index);
            final String name  = child.getLocalName();

            if (name == null || name.length == 0) {
               continue;
            }

            final String value = child.getTextContent();
            map.put(name, value);
        }

        return map;
    }
}