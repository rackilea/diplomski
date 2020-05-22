/*
 * Parses the xml schema string into a hashmap
 * note that hashmap has a form of a tree
 */
public HashMap<String, Object> getXmlElements(InputStream xml) {
    //---
    XSOMParser parser = new XSOMParser();
    //---
    try{
        parser.parse(xml);
    } catch(Exception ex){
        logger.fatal("Could not parse the inputstream: " + ex);
    }
    //---
    XSSchemaSet schemaSet = null;
    try {
        schemaSet = parser.getResult();
    } catch (SAXException ex) {
        logger.fatal("Could not parse: " + ex);
    }
    //---
    HashMap<String, Object> hmReturned = new HashMap<String, Object>();
    HashMap<String, Object> hm = new HashMap<String, Object>();
    Iterator <XSElementDecl> itre = schemaSet.iterateElementDecls();
    //---
    while(itre.hasNext()) {
        XSElementDecl xse = (XSElementDecl) itre.next();
        hmReturned.put(xse.getName(), hm);
        XSComplexType xscomp = xse.getType().asComplexType();
        if (xscomp != null) {
            XSContentType xscont = xscomp.getContentType();
            XSParticle particle = xscont.asParticle();
            getElementsRecursively(hm,  particle);
        }
    } 
    //---
    return hmReturned;
}

/*
 * recursive helper method of getXmlElements
 * note that since we don't know the "deepness" of the
 * schema a recursive way of implementation was necessary
 */
private void getElementsRecursively(HashMap<String, Object> hm, XSParticle xsp) {
     if(xsp != null){
         XSTerm term = xsp.getTerm();
         if(term.isElementDecl()) {
             XSComplexType xscmp =  (term.asElementDecl()).getType().asComplexType();
             //---
             if (xscmp == null){
                 if(xsp.getMinOccurs() == 0)
                     hm.put(term.asElementDecl().getName(), "|");
                 else
                     hm.put(term.asElementDecl().getName(), "=");
             } else{
                 XSContentType xscont = xscmp.getContentType();
                 XSParticle particle = xscont.asParticle();
                 HashMap<String, Object> newHm = new HashMap<String, Object>();
                 getElementsRecursively(newHm, particle);
                 hm.put(term.asElementDecl().getName(), newHm);
             }
             //---
         } else if(term.isModelGroup()){
             XSModelGroup model = term.asModelGroup();
             XSParticle[] parr = model.getChildren();
             for(XSParticle partemp : parr ){
               getElementsRecursively(hm, partemp);
             }
         }
     }
}