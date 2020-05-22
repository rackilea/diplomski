public void PDFLetterGenerate (String args) throws Exception {
    PDPage main_page = new PDPage();
    PDPage new_page = new PDPage(); 

    text = args;
    text = text.replace("\n", "").replace("\r", "");

    if(file.exists()) file.delete();
    file.createNewFile();
    //Creating PDF document object 
    PDDocument document = new PDDocument();       
    document.addPage(main_page);  
    mainBody(document, main_page);      
    document.addPage(new_page);                          
    if(!newPage) document.removePage(new_page);

    document.save(file);
    document.close(); 
}