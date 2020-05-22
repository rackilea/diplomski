public void getReportData() throws IOException {
    HSSFWorkbook workbook = new HSSFWorkbook();
    HSSFSheet sheet = workbook.createSheet();
    HSSFRow row = sheet.createRow(0);
    HSSFCell cell = row.createCell(0);
    cell.setCellValue(0.0);

    FacesContext facesContext = FacesContext.getCurrentInstance();
    ExternalContext externalContext = facesContext.getExternalContext();
    externalContext.setResponseContentType("application/vnd.ms-excel");
    externalContext.setResponseHeader("Content-Disposition", "attachment; filename=\"my.xls\"");

    workbook.write(externalContext.getResponseOutputStream());
    facesContext.responseComplete();
}