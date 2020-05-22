public class NamespaceContextImpl implements NamespaceContext {
   private final Map<String, String> namespaces;
   private final String defaultNamespaceURI;

   public NamespaceContextImpl(String defaultNamespaceURI,
                               Map<String, String> namespaces) {
      this.defaultNamespaceURI = defaultNamespaceURI;
      this.namespaces = namespaces;
   }

   public Iterator getPrefixes(String namespaceURI) {
      throw new IllegalStateException("Not Implemented.");
   }

   public String getPrefix(String namespaceURI) {
      throw new IllegalStateException("Not Implemented.");
   }

   public String getNamespaceURI(String prefix) {
      if (prefix == null) {
         throw new IllegalArgumentException();
      }
      if (prefix.equals(XMLConstants.XMLNS_ATTRIBUTE)) {
         return XMLConstants.XMLNS_ATTRIBUTE_NS_URI;
      }
      if (prefix.equals(XMLConstants.XML_NS_PREFIX)) {
         return XMLConstants.XML_NS_URI;
      }
      if (prefix.equals(XMLConstants.DEFAULT_NS_PREFIX)) {
         return defaultNamespaceURI;
      }
      String result = namespaces.get(prefix);
      if (result == null) {
         result = XMLConstants.NULL_NS_URI;
      }
      return result;
   }
}