@Component
public class RequestClient {

    private static final String WSSE_PREFIX = "wsse";
    private static final String WSSE_NAMESPACE = "http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd";
    private static final String NS2_PREFIX = "ns2";
    private static final String NS2_NAMESPACE = "http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd";

    private buildSoaprequest(){
        ...
        SOAPEnvelope soapEnvelope = soapMessage.getSOAPPart().getEnvelope();
        soapEnvelope.addNamespaceDeclaration(WSSE_PREFIX, WSSE_NAMESPACE);
        soapEnvelope.addNamespaceDeclaration(NS2_PREFIX, NS2_NAMESPACE);
        SOAPHeader soapHeader = soapMessage.getSOAPHeader();
        removeUndesiredBodyNamespaceEntries(soapHeader.getChildElements());
        soapHeader.setPrefix(WSSE_PREFIX);
        addDesiredBodyNamespaceEntries(soapHeader.getChildElements());              
        soapMessage.saveChanges();
        ...
    }

    private void addDesiredBodyNamespaceEntries(Iterator childElements) {
        while (childElements.hasNext()) {
          final Object childElementNode = childElements.next();
          if (childElementNode instanceof SOAPElement) {
            SOAPElement soapElement = (SOAPElement) childElementNode;
            soapElement.setPrefix(WSSE_PREFIX); 
            addDesiredBodyNamespaceEntries(soapElement.getChildElements());
          }
        }
      }

    private void removeUndesiredBodyNamespaceEntries(Iterator childElements) {
        while (childElements.hasNext()) {
          final Object childElementNode = childElements.next();
          if (childElementNode instanceof SOAPElement) {
            SOAPElement soapElement = (SOAPElement) childElementNode;

            //remove any prefix/namespace entries added by JAX-WS in the body element
            //it cannot be null, so it will leave wsse
            for (String prefix : getNamespacePrefixList(soapElement.getNamespacePrefixes())) {
              if (prefix != null) {
                soapElement.removeNamespaceDeclaration(prefix);
              }
            }
            // recursively remove prefix/namespace entries in child elements
            removeUndesiredBodyNamespaceEntries(soapElement.getChildElements());
          }
        }
      }

     private Set<String> getNamespacePrefixList(Iterator namespacePrefixIter) {
        Set<String> namespacePrefixesSet = new HashSet<>();
        while (namespacePrefixIter.hasNext()) {
          namespacePrefixesSet.add((String) namespacePrefixIter.next());
        }
        return namespacePrefixesSet;
      }