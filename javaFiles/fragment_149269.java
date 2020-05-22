private ParseObject uploadPDFToParse(File PDFFile, ParseObject po, String columnName){

    if(PDFFile != null){
        Log.d("EB", "PDFFile is not NULL: " + PDFFile.toString());
        int size = (int) file.length();
        byte[] pdfBytes = new byte[size];

        try {
            BufferedInputStream buf = new BufferedInputStream(new FileInputStream(file));
            buf.read(pdfBytes, 0, pdfBytes.length);
            buf.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        // Create the ParseFile
        ParseFile file = new ParseFile(PDFFile.getName() , pdfBytes);
        po.put(columnName, file);

        // Upload the file into Parse Cloud
        file.save();
        po.saveInBackground();
    }
    return po;
}