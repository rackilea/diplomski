PDFTextStripper pdfStripper = null;
PDDocument pdDoc = null;
COSDocument cosDoc = null;
String parsedText=""; // append the text to this every time
File folder = new File("/yourFolder"); // put all the pdf files in a folder
File[] listOfFiles = folder.listFiles(); // get all the files as an array

    for (File file : listOfFiles) { // cycle through this array 
        if (file.isFile()) { // for every file
             try { //do the same 
                 PDFParser parser = new PDFParser(new FileInputStream(file));
                 parser.parse();
                 cosDoc = parser.getDocument();
                 pdfStripper = new PDFTextStripper();
                 pdDoc = new PDDocument(cosDoc);
                 pdfStripper.setStartPage(1);
                 pdfStripper.setEndPage(pdDoc.getNumberOfPages()); // if always till the last page
                 parsedText += pdfStripper.getText(pdDoc) +  System.lineSeparator(); // append the text to the String
                }catch (IOException e) {
                 // TODO Auto-generated catch block
                 e.printStackTrace();
               } 
       }
  }