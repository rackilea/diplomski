@GetMapping(value = "/test/{idDocument}", produces = MediaType.APPLICATION_PDF_VALUE)
public void test(@PathVariable("idDocument") String idDocument, HttpServletRequest request,
        HttpServletResponse response) throws FOPException, IOException {

    SisDocuments document = documentRepository.getOne(Long.valueOf(idDocument));

    documentService.constructDocumentById(document);

    try {
        // // get your file as InputStream
        File f = new File("employee.pdf");
        InputStream is = new FileInputStream(f);

        org.apache.commons.io.IOUtils.copy(is, response.getOutputStream());

        // copy it to response's OutputStream
        response.addHeader("Content-disposition", "attachment; filename=" + "employee.pdf");
        response.setContentType("application/pdf");
        response.flushBuffer();
    } catch (IOException ex) {
        throw new RuntimeException("IOError writing file to output stream");
    }

}