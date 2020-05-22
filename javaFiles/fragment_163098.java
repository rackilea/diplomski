@RequestMapping(value = "/results-pdf", method = RequestMethod.GET)
@ResponseBody
public void generateResultsPdf(@RequestParam("year") String year, HttpServletResponse response) {

    List<Student> studentList = studentService.getResultsByYear(year);
    JRDataSource jrDataSource = new JRBeanCollectionDataSource(studentList);
    Map<String, Object> parameterMap = new HashMap<>();
    parameterMap.put("title", "Results table"));
    parameterMap.put("datasource", jrDataSource);

    try {
            JasperReport jasperReport = JasperCompileManager.compileReport(RESULTS_PDF_REPORT_PATH);
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameterMap, jrDataSource);

            String filename = "new-filename.pdf";

            response.setContentType("application/pdf");
            response.addHeader("Content-disposition", "attachment; filename=" +filename);
            OutputStream outputStream = response.getOutputStream();

            JasperExportManager.exportReportToPdfStream(jasperPrint, outputStream);
        } catch (JRException | IOException e) {
            logger.error("Error in generating pdf : {}", e);
        }
}