Body newerBody = ((Document)newerPackage.getMainDocumentPart().getJaxbElement()).getBody();
        Body olderBody = ((Document)olderPackage.getMainDocumentPart().getJaxbElement()).getBody();

        // 2. Do the differencing
        java.io.StringWriter sw = new java.io.StringWriter();
        Docx4jDriver.diff( XmlUtils.marshaltoW3CDomDocument(newerBody).getDocumentElement(),
                        XmlUtils.marshaltoW3CDomDocument(olderBody).getDocumentElement(),
                           sw);

        // 3. Get the result
        String contentStr = sw.toString();
        System.out.println("Result: \n\n " + contentStr);
        Body newBody = (Body) org.docx4j.XmlUtils
                        .unmarshalString(contentStr);