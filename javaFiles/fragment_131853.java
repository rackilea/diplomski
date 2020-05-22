//Read the pdf 
PdfReader reader = new PdfReader(inputstream);
//Use PdfStamper in append mode
stamp = new PdfStamper(reader, new FileOutputStream(file), '\0', true); 

//Read the image
Image img = Image.getInstance(ImageIO.read(imgStream), null);

float w = img.getScaledWidth();
float h = img.getScaledHeight();
Rectangle location = new Rectangle(70, 770 - h, 70 + w, 770);

//Create stamp annotation           
PdfAnnotation stampAnnot = PdfAnnotation.createStamp(stamp.getWriter(), location, null, "ITEXT");
img.setAbsolutePosition(0, 0);
//Create new PdfContentByte from the stamp writer
//If you use cd = stamp.getOverContent(1) - you'll invalidate the signatures
PdfContentByte cb = new PdfContentByte(stamp.getWriter());
PdfAppearance app = cb.createAppearance(w, h);
app.addImage(img);
stampAnnot.setAppearance(PdfName.N, app);
stampAnnot.setFlags(PdfAnnotation.FLAGS_PRINT);

stamp.addAnnotation(stampAnnot, 1);
reader.close();