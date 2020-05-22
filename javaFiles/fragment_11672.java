StringBuilder myHtml = new StringBuilder(); 
 myHtml.append("<html><img 
 src=\""+serverName+"/userApi/resources/images/invoice-bg.jpg\" 
 style=\"margin-top:-4px;\" ></img></html>");
// if you have html source in hand, use it to generate document object
Document document = XMLResource.load( new ByteArrayInputStream( 
myHtml.toString().getBytes() ) ).getDocument();

ITextRenderer renderer = new ITextRenderer();
renderer.setDocument( document, null );

renderer.layout();

String fileNameWithPath = "D:/Temp/PDF-XhtmlRendered.pdf";
FileOutputStream fos = new FileOutputStream( fileNameWithPath );
renderer.createPDF( fos );
fos.close();
System.out.println( "File 1: '" + fileNameWithPath + "' created." );