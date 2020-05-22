@RequestMapping(value = "helloReport1", method = RequestMethod.GET)
  @ResponseBody
  public void getRpt1(HttpServletResponse response) throws JRException, IOException {
    InputStream jasperStream = this.getClass().getResourceAsStream("/jasperreports/HelloWorld1.jasper");
    Map<String,Object> params = new HashMap<>();
    JasperReport jasperReport = (JasperReport) JRLoader.loadObject(jasperStream);
    JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params, new JREmptyDataSource());

    response.setContentType("application/x-pdf");
    response.setHeader("Content-disposition", "inline; filename=helloWorldReport.pdf");

    final OutputStream outStream = response.getOutputStream();
    JasperExportManager.exportReportToPdfStream(jasperPrint, outStream);
  }