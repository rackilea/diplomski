public String getNamespaceURI(String prefix) {
    if ("cam".equals(prefix))
       // like abvce
    else if ("s2".equals(prefix))
       return "urn:xxx:1.0:xxx.core.xxx.Service2";
    else
       return XMLConstants.NULL_NS_URI;
}