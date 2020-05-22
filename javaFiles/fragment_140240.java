protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

    String savePath = request.getServletContext().getRealPath("") + File.separator + "files";       

    File fileSaveDir = new File(savePath);
    if (!fileSaveDir.exists()) {
        fileSaveDir.mkdir();
    }

    for (Part part : request.getParts()) {
        String fileName = findFileName(part);
        part.write(savePath + File.separator + fileName);
    }   
}

private String findFileName(Part part) {
    String[] items = part.getHeader("content-disposition").split(";");
    for (String item : items) {
        if (item.trim().startsWith("filename")) {
            return item.substring(item.indexOf("=") + 2, item.length() - 1);
        }
    }
    return "";
}