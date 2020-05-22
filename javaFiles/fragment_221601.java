NodeList list = doc.getElementsByTagName("wsu:Timestamp");
    Node node = list.item(0);
    Element tempEl = XMLHelper.getChildElementsByTagName(doc.getDocumentElement(), "Header").get(0);
    Element securityElement = XMLHelper.getChildElementsByTagName(tempEl, "Security").get(0);

    tempEl = XMLHelper.getChildElementsByTagName(securityElement, "Assertion").get(0);
    Attr attr = (Attr)tempEl.getAttributes().getNamedItem("AssertionID");
    tempEl.setIdAttributeNode(attr, true);
    String ref = "#" + attr.getValue();

    List<Reference> refs = new ArrayList<Reference>();
    refs.add(fac.newReference(
            ref,
            fac.newDigestMethod("http://www.w3.org/2000/09/xmldsig#sha1", null),
            Collections.singletonList(fac.newTransform("http://www.w3.org/2001/10/xml-exc-c14n#",(TransformParameterSpec) null)),
            null,
            null));