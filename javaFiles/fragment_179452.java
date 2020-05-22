@RequestMapping(value = { "/pdfDownload" }, method = RequestMethod.GET)
public void pdfDownload(HttpServletRequest request, HttpServletResponse response) {

      //using bytearrayoutputstream instead of response outputstream,
      ByteArrayOutputStream  out = new ByteArrayOutputStream();


        //Logic OF generating PDF file

    // set response
    response.setContentType("application/pdf");
    response.setCharacterEncoding("UTF-8");
    response.setHeader("Content-Disposition", "inline; filename=Mypdf12345.pdf");

    //transferring that stream to response output stream
    out.writeTo(response.getOutputStream());

}