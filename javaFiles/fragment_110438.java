Visit http://today.java.net/pub/a/today/2007/06/26/generating-pdfs-with-flying-saucer-and-itext.html
protected void doProcess(HttpServletRequest request,
        HttpServletResponse response){
    response.setContentType("application/pdf;");
    response.setHeader("Content-Disposition", "attachment; filename=Filenametodownload.pdf");       
    String reportContent = "<html><body><b>This is sample HTML</b></body></html>";
    ServletOutputStream sos =null;
    try {
        sos = response.getOutputStream();
    } catch (IOException e1) {          
        e1.printStackTrace();
    }
    String st = System.getProperty("user.dir");
    // ITextRenderer is only works fine with compailed version of core-renderer.jar 
    //Jar available in http://wo-repository.doit.com.br/content/repositories/thirdparty/org/xhtmlrenderer/core-renderer/R8-final/
    ITextRenderer renderer = new ITextRenderer();   
    //System.out.println(reportContent);
    renderer.setDocumentFromString(reportContent);
    renderer.layout();
    try {
        renderer.createPDF(sos);
    } catch (DocumentException e) {         
        e.printStackTrace();
    }

    try {       
        sos.close();
        session.removeAttribute("ReportContent");
    } catch (IOException e) {           
        e.printStackTrace();
    }
}