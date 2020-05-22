String finalXhtml=xhtmlparser(xmlText);
ByteArrayInputStream finalXhtmlStream = new ByteArrayInputStream(finalXhtml.getBytes());

String HTML_TO_PDF = "ConvertedFile.pdf";
OutputStream os = new FileOutputStream(HTML_TO_PDF);      

Document document = XMLResource.load(finalXhtmlStream).getDocument();

ITextRenderer renderer = new ITextRenderer();
renderer.setDocument(document, null);
renderer.layout();
renderer.createPDF(os) ;    
os.close();