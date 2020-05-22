@RequestMapping(method = RequestMethod.POST,params={"xls"})
public void toXls(HttpServletRequest request,HttpServletResponse response,
        @RequestParam("from_date") String fromDate, @RequestParam("to_date") String toDate)throws IOException, URISyntaxException{

    String sourceFileName = "LoginActivityExcelReport";
    Map<String, Object> parameters = new HashMap<String, Object>();
    **parameters.put(JRParameter.IS_IGNORE_PAGINATION, Boolean.TRUE);**
    List<ActivityReportItem> beanCollection = activityReportService.getActivityListForDownload(fromDate, toDate);
    byte[] xlsReport = new byte[1]; 
    try {           
        JRBeanCollectionDataSource beanColDataSource = new JRBeanCollectionDataSource(beanCollection);
        logger.info("!!! Compiling and Generating Excel Report from "+sourceFileName+".jrxml file");
        xlsReport = jasperUtil.generateReportXls(request, parameters, sourceFileName, beanColDataSource);
    } catch (Exception e) {
        logger.error("Error while generating pdf file", e);
    }
    response.addCookie(new Cookie("downloadCompleted","true"));
    response.setContentType("application/vnd.ms-excel");
    response.setHeader("Content-Disposition", String.format("attachment; filename=\"%s\"", "LoginActivityReport.xls"));
    response.setContentLength(xlsReport.length);
    response.getOutputStream().write(xlsReport);
    response.getOutputStream().flush();
    response.getOutputStream().close(); 
}