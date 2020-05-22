Marshaller m = ctx.createMarshaller();
    m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
    try {
        m.setProperty("com.sun.xml.internal.bind.namespacePrefixMapper", new MyNamespaceMapper());
        //m.setProperty("com.sun.xml.bind.namespacePrefixMapper", new MyNamespaceMapper());
    } catch(PropertyException e) {
        // In case another JAXB implementation is used
    }