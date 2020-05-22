ITextRenderer renderer = new ITextRenderer();
renderer.getSharedContext().setReplacedElementFactory(new ProfileImageReplacedElementFactory(renderer.getSharedContext().getReplacedElementFactory()));
renderer.setDocumentFromString(xhtmlDocumentAsString);
renderer.layout();
os = response.getOutputStream();
renderer.createPDF(os);