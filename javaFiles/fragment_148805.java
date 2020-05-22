// if you have html source in hand, use it to generate document object
Document document = XMLResource.load( new ByteArrayInputStream( yourXhtmlContentAsString.getBytes() ) ).getDocument();

ITextRenderer renderer = new ITextRenderer();
renderer.setDocument( document, null );

renderer.layout();

String fileNameWithPath = outputFileFolder + "PDF-XhtmlRendered.pdf";
FileOutputStream fos = new FileOutputStream( fileNameWithPath );
renderer.createPDF( fos );
fos.close();
System.out.println( "File 1: '" + fileNameWithPath + "' created." );