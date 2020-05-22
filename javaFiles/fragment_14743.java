protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,  IOException {
if (!ServletFileUpload.isMultipartContent(request)) {
    throw new ServletException("Content type is not multipart/form-data");
}

PrintWriter out = response.getWriter();
try {
    List<FileItem> fileItemsList = uploader.parseRequest(request);

    FileItem fileItem = fileItemsList.get(0);
    System.out.println("FieldName=" + fileItem.getFieldName());
    System.out.println("FileName=" + fileItem.getName());
    System.out.println("ContentType=" + fileItem.getContentType());
    System.out.println("Size in bytes=" + fileItem.getSize());
    InputStream inputStream=fileItem.getInputStream();
            Workbook workbook;
            if (fileItem.getName().endsWith("xlsx")) {
                workbook = new XSSFWorkbook(inputStream);
            } else if (fileItem.getName().endsWith("xls")) {
                workbook = new HSSFWorkbook(inputStream);
            } else {
                throw new IllegalArgumentException("The specified file is not Excel file");
            }

    } catch (Exception e) {
    e.printStackTrace();
    }

}