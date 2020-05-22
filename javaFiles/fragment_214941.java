boolean isMultipart = ServletFileUpload.isMultipartContent(request);

if (isMultipart) {
    FileItemFactory factory = new DiskFileItemFactory();
    ServletFileUpload upload = new ServletFileUpload(factory);

    try {
        List items = upload.parseRequest(request);
        Iterator iterator = items.iterator();
        while (iterator.hasNext()) {
            FileItem item = (FileItem) iterator.next();

            if (!item.isFormField()) {
                String fileName = item.getName();

                String root = getServletContext().getRealPath("/");
                File path = new File(root + "/uploads");
                if (!path.exists()) {
                    boolean status = path.mkdirs();
                }

                File uploadedFile = new File(path + "/" + fileName);
                System.out.println(uploadedFile.getAbsolutePath());
                item.write(uploadedFile);
            }
        }
    } catch (FileUploadException e) {
        e.printStackTrace();
    } catch (Exception e) {
        e.printStackTrace();
    }
}