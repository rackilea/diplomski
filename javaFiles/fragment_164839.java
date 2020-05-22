// Process the uploaded items
Iterator<FileItem> iter = items.iterator();
while (iter.hasNext()) {
    FileItem item = iter.next();

    if (item.isFormField()) {
        processFormField(item);
    } else {
        processUploadedFile(item);
    }
}