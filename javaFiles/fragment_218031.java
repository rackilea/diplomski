Element rootElem = new Builder().build(ins).getRootElement();
XPathContext xc = XPathContext.makeNamespaceContext(rootElem);    
Element firstEntry = (Element) rootElem.query("atom:entry", xc).get(0); 
Document doc = new Document((Element)firstEntry.copy());
Element root = doc.getRootElement();
recursive(root,root);

static void recursive(Element root, Element child){
        root.addNamespaceDeclaration(child.getNamespacePrefix(), child.getNamespaceURI());
        if (child.getChildElements().size()>0){
            int i = child.getChildElements().size();
            for (int k=0;k<i;k++){
                recursive(root,child.getChildElements().get(k));
            }
        }
    }