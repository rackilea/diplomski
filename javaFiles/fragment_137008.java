DOMImplementation domImplementation = document.getImplementation();
    if (domImplementation.hasFeature("LS", "3.0")
            && domImplementation.hasFeature("Core", "2.0")) {
        DOMImplementationLS domImplementationLS = (DOMImplementationLS) domImplementation
                .getFeature("LS", "3.0");
        LSSerializer lsSerializer = domImplementationLS
                .createLSSerializer();
        DOMConfiguration domConfiguration = lsSerializer.getDomConfig();
        if (domConfiguration.canSetParameter("format-pretty-print",
                Boolean.TRUE)) {
            lsSerializer.getDomConfig().setParameter("format-pretty-print",
                    Boolean.TRUE);
            LSOutput lsOutput = domImplementationLS.createLSOutput();
            lsOutput.setEncoding("UTF-8");
            StringWriter stringWriter = new StringWriter();
            lsOutput.setCharacterStream(stringWriter);
            lsSerializer.write(document, lsOutput);
            return stringWriter.toString();
        } else {
            throw new RuntimeException(
                    "DOMConfiguration 'format-pretty-print' parameter isn't settable.");
        }
    } else {
        throw new RuntimeException(
                "DOM 3.0 LS and/or DOM 2.0 Core not supported.");
    }