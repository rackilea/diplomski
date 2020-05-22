// Process the uploaded items
boolean fileUploaded = false;
Iterator<FileItem> iter = items.iterator();
while (iter.hasNext()) {
    FileItem item = iter.next();

    if (item.isFormField()) {
        processFormField(item);
    } else {
        processUploadedFile(item);
        fileUploaded = true;
    }
}

if (!fileUploaded) {
    // process some default file
}