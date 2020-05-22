if(req.getParameter("report").equals("true"))
{
  req.getSession().setAttrinute("REPORT_OK",false);
  //If the query string parameter is set, generate the PDF.
  if(!PdfReportGenerator.generateReport(res, repositoryURI)) {
    // Something went wrong, so redirect the browser.
    res.sendRedirect(req.getRequestURI());
  }else{
    req.getSession().setAttrinute("REPORT_OK",true);
  }
}