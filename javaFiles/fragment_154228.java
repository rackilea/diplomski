@FXML void endButton(ActionEvent event) {
List<String> list = new ArrayList<String>();        
for (Person item : table.getItems()) {       
    String a = item.getName();
    list.add(a);
}     
String[] simpleArray = new String[list.size()];
list.toArray(simpleArray);
try{   
    XWPFDocument doc = new XWPFDocument(new FileInputStream(new File("input.docx")));               
    findAndRemplaceString(doc,simpleArray);
    FileOutputStream fileOutputStream = new FileOutputStream(new File("output.docx")); 
    doc.write(fileOutputStream);
    fileOutputStream.close();
    doc.close();                    
}catch (Exception e) { 
    System.out.println("erreur  " + e);
    }
}