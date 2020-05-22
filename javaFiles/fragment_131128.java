DefaultXPath xpath = new DefaultXPath("//x:html/x:body/...");
Map<String,String> namespaces = new TreeMap<String,String>();
namespaces.put("x","http://www.w3.org/1999/xhtml");
xpath.setNamespaceURIs(namespaces);

list = xpath.selectNodes(document);