public void printOrder(){
    try {
        File myFile = new File(finished);
        //Desktop.getDesktop().open(myFile);
        Desktop.getDesktop().print(myFile);
        doc.close();
    } catch (IOException ex) {
        // no application registered for PDFs
    }
}