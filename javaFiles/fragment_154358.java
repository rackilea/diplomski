ServletFileUpload upload = new ServletFileUpload(factory);
upload.setHeaderEncoding("UTF-8"); 

FileItemIterator iter = upload.getItemIterator(request);
while (iter.hasNext()) {
    FileItemStream item = iter.next();
    String name = item.getFieldName();
    InputStream stream = item.openStream();
    if (item.isFormField()) {
        String value = Streams.asString(stream, "UTF-8");
    } 
}