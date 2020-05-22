String content = loadHtml();
ITextRenderer renderer = new ITextRenderer();
renderer.getSharedContext().setReplacedElementFactory(new MediaReplacedElementFactory(renderer.getSharedContext().getReplacedElementFactory()));
renderer.setDocumentFromString(content.toString());
renderer.layout();
final ByteArrayOutputStream baos = new ByteArrayOutputStream();
renderer.createPDF(baos);
// baos.toByteArray();