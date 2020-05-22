ServletFileUpload upload = new ServletFileUpload(factory);
List<FileItem> items = upload.parseRequest(request);
if (items.isEmpty()) {
    // process some default file
} else {
    // process uploaded file
}