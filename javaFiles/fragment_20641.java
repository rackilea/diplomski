DiskFileItemFactory factory = new DiskFileItemFactory();
ServletContext servletContext = this.getServletConfig().getServletContext();
File repository = (File) servletContext.getAttribute("javax.servlet.context.tempdir");
factory.setRepository(repository);

ServletFileUpload upload = new ServletFileUpload(factory);
List<FileItem> items = upload.parseRequest(request);
for (FileItem item : items) {
    if (!item.isFormField()) {
        writer.println("fieldName = " + item.getFieldName());
        writer.println("fileName = " + item.getName());
        writer.println("contentType = " + item.getContentType());
        writer.println("size [bytes] = " + item.getSize());
        File uploadedFile = File.createTempFile("temp", ".txt");
        item.write(uploadedFile);
        writer.println("stored as  " + uploadedFile.getAbsolutePath());
    }
}