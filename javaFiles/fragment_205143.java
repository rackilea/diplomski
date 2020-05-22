protected void service(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
    try {
        // Get the text that will be added to the PDF
        String text = request.getParameter("text");
        if (text == null || text.trim().length() == 0) {
             text = "You didn't enter any text.";
        }
        // step 1
        Document document = new Document();
        // step 2
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PdfWriter.getInstance(document, baos);
        // step 3
        document.open();
        // step 4
        document.add(new Paragraph(String.format(
            "You have submitted the following text using the %s method:",
            request.getMethod())));
        document.add(new Paragraph(text));
        // step 5
        document.close();

        // setting some response headers
        response.setHeader("Expires", "0");
        response.setHeader("Cache-Control",
            "must-revalidate, post-check=0, pre-check=0");
        response.setHeader("Pragma", "public");
        // setting the content type
        response.setContentType("application/pdf");
        // the contentlength
        response.setContentLength(baos.size());
        // write ByteArrayOutputStream to the ServletOutputStream
        OutputStream os = response.getOutputStream();
        baos.writeTo(os);
        os.flush();
        os.close();
        // if you also want to write these bytes to a file, add:
        OutputStream fos = new FileOutputStream(pathToFile);
        baos.writeTo(fos);
        fos.flush();
        fos.close();
    }
    catch(DocumentException e) {
        throw new IOException(e.getMessage());
    }
}