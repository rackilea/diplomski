File archivo = new File("MyPath");    
    DiskFileItemFactory factory = new DiskFileItemFactory();
    factory.setRepository(archivo);
    ServletFileUpload fileUpload = new ServletFileUpload(factory);
    List<FileItem> items = fileUpload.parseRequest(request.raw());
    FileItem item = items.stream()
                  .filter(e -> "file".equals(e.getFieldName()))
                .findFirst().get();
      String fileName = item.getName();
    item.write(new File(archivo, fileName));