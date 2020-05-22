//Read the source PDF
PdfReader reader = new PdfReader(inputstream);
//Create PdfStamp object
stamp = new PdfStamper(reader, new FileOutputStream(file), '\0', true);

//Create the proper annotation
PdfAnnotation annot = PdfAnnotation.createFreeText(stamp.getWriter(),  new Rectangle(150, 150, 200, 200), "Annotation 1", pcb);
annot.setFlags(PdfAnnotation.FLAGS_PRINT);

//Insert the annotation         
stamp.addAnnotation(annot, 1);
//Close the stamp
stamp.close();