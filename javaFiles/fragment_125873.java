protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
    processRequest(request, response);

    if (request.getParameter("upload-CroppedImage") != null) {
        String dataURI = request.getParameter("croppedImage");
        String data = dataURI.substring(dataURI.indexOf(',')); // TODO: Input validation
        byte[] imgBytes = parseBase64Binary(data);

        File outputfile = new File("F:\\Users\\Joery v2\\Pictures\\saved.jpg");
        writeBytesToFile(imgBytes, outputFile);
    }
}

private void writeBtesToFile(byte[] bytes, File file) {
    OutputStream out;

    try {
        out = new FileOutputStream(file);
        out.write(bytes);
    } 
    finally {
        out.close();
    }
}