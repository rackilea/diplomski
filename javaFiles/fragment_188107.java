Document doc = ...;

Multimap<String, String> bindings = LinkedHashMultimap.create();
DocumentTraversal dt = (DocumentTraversal) doc;
NodeIterator i = dt.createNodeIterator(doc, NodeFilter.SHOW_ELEMENT,
        null, false);
Element element = (Element) i.nextNode();
while (element != null) {
    String prefix = element.getPrefix();
    if (prefix != null) {
        String uri = element.getNamespaceURI();
        bindings.put(prefix, uri);
    }
    element = (Element) i.nextNode();
}