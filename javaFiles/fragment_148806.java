ITextRenderer renderer = new ITextRenderer();

// if you have html source in hand, use it to generate document object
renderer.setDocumentFromString( yourXhtmlContentAsString );
renderer.layout();

String fileNameWithPath = outputFileFolder + "PDF-FromHtmlString.pdf";
FileOutputStream fos = new FileOutputStream( fileNameWithPath );
renderer.createPDF( fos );
fos.close();

System.out.println( "File 2: '" + fileNameWithPath + "' created." );