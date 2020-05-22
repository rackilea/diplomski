ITextRenderer renderer = new ITextRenderer();
renderer.getSharedContext().setUserAgentCallback(
        new PackageUserAgentCallback(renderer.getOutputDevice(), Resources.class));
System.out.println(renderer.getSharedContext().getBaseURL());
renderer.setDocumentFromString(new String(htmlByteArray));

renderer.layout();
renderer.createPDF(os);