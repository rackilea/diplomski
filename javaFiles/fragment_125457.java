@Put
public void handleUpload(Representation entity) {
    List<FileItem> items = new RestletFileUpload(new DiskFileItemFactory())
                 .parseRepresentation(representation);
    for (FileItem item : items) {
        if (!item.isFormField()) {
            MediaType type = MediaType.valueOf(item.getContentType());
            InputStream inputStream = item.getInputStream();
        }
    }
}