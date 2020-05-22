FileItemFactory factory = new DiskFileItemFactory();
ServletFileUpload upload = new ServletFileUpload(factory);
Iterator<FileItemStream> fileIter = upload.getItemIterator(request);

HashMap<String,String> parameters = new HashMap<String,String>()
while(fileIter.hasNext()){
  FileItemStream fileItem = fileIter.next();
  if(fileItem.isFormFIeld()){
     paramName = item.getFieldName();
     InputStream stream = item.openStream();
     paramValue =  Streams.asString(stream);
     parameters.put(paramName,paramValue )
  }else{
     InputStream instrm =  item.openStream();
     //Receive and save File
  }

}