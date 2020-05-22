// Create a factory for disk-based file items
FileItemFactory factory = new DiskFileItemFactory();

// Create a new file upload handler
ServletFileUpload upload = new ServletFileUpload(factory);

// Parse the request
List /* FileItem */ items = upload.parseRequest(request);

Iterator iter = items.iterator();
while (iter.hasNext()) {
    FileItem item = (FileItem) iter.next();
    InputStream uploadedStream = item.getInputStream();
    // your database code goes here
    uploadedStream.close();
}