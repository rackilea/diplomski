// processUploadedFile
if (!item.isFormField()) {
    String fieldName = item.getFieldName();
    String fileName = item.getName();
    String contentType = item.getContentType();
    boolean isInMemory = item.isInMemory();
    long sizeInBytes = item.getSize();
    ...
}