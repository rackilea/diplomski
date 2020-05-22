ServletFileUpload upload = new ServletFileUpload();
FileItemIterator iter = upload.getItemIterator(request);
while (iter.hasNext()) {
    FileItemStream item = iter.next();
    ...
}