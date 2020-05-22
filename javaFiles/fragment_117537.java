private static List<Object> getAllElementFromObject(Object obj, Class<?> toSearch) {

    List<Object> result = new ArrayList<Object>();
    if (obj instanceof JAXBElement) obj = ((JAXBElement<?>) obj).getValue();

    if (obj.getClass().equals(toSearch))
        result.add(obj); 
    else if (obj instanceof ContentAccessor) {
        List<?> children = ((ContentAccessor) obj).getContent();
        for (Object child : children) {
            result.addAll(getAllElementFromObject(child, toSearch));
        }
    }
    return result; 
}


private void replaceTextValue(WordprocessingMLPackage template, String name, String placeholder ) throws Exception{     

    List<Object> texts = getAllElementFromObject(template.getMainDocumentPart(), SdtBlock.class);

    for (Object text : texts) {         

        SdtBlock textElement = (SdtBlock) text;
        List<Object> cList = textElement.getSdtContent().getContent();

        SdtPr pr = textElement.getSdtPr();
        List<Object> al = pr.getRPrOrAliasOrLock();

        for (Object alias : al) {   // go through all SdtPr objects

            if ( alias.getClass().toString().contains("org.docx4j.wml.Tag")) {

                String CTagVal = ((org.docx4j.wml.Tag) alias).getVal(); 

                if (CTagVal.equalsIgnoreCase(placeholder))  {   

                ClassFinder finder = new ClassFinder(Text.class);
                new TraversalUtil(cList, finder);

                for (Object o : finder.results) {
                    Object o2 = XmlUtils.unwrap(o);
                    if (o2 instanceof org.docx4j.wml.Text) {
                    org.docx4j.wml.Text txt = (org.docx4j.wml.Text)o2;
                    txt.setValue(name);
                    } else {
                    System.out.println( XmlUtils.marshaltoString(o, true, true));
                    }
                    }

                }

        }           

    }
}
}