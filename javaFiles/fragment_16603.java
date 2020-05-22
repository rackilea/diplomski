Iterator<FileItem> iter = items.iterator();
while (iter.hasNext()) {  
  FileItem item = iter.next();   
 if (item.isFormField()) {      
  processFormField(item);   
 } else if (!item.isFormField()) { 
 // Process a file upload
    String fieldName = item.getFieldName();  
  String fileName = item.getName();   
 String contentType = item.getContentType(); 
   boolean isInMemory = item.isInMemory();  
  long sizeInBytes = item.getSize();

//here you change the name of the uploaded file and then write it 

    File uploadedFile = new File(dir , "fileName");   
 item.write(uploadedFile);


  }
}