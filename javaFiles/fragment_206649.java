File folder = new File("D:\\projects\\emrs3\\PMS\\Claim\\PaperRTF");                                       
File[] listOfFiles = folder.listFiles();                                                                   
int j =3 ;                                                                                                 
for (int i = 0; i <j ; i++) {                                                                              
    if (listOfFiles[i].isFile()) {                                                                         

        //System.out.println("File " + listOfFiles[i].getName());                                          
        Document doc = new Document(listOfFiles[i].getAbsolutePath());                                     

        PrinterJob pj = PrinterJob.getPrinterJob();                                                        

        // Initialize the Print Dialog with the number of pages in the document.                           
        PrintRequestAttributeSet attributes = new HashPrintRequestAttributeSet();                          
        attributes.add(new PageRanges(1, doc.getPageCount()));                                             

        // Create the Aspose.Words' implementation of the Java Pageable interface.                         
        AsposeWordsPrintDocument awPrintDoc = new AsposeWordsPrintDocument(doc);                           

        // Pass the document to the printer.                                                               
        pj.setPageable(awPrintDoc);                                                                        

        // Print the document with the user specified print settings.                                      
        pj.print(attributes);