@RequestMapping(value = "exportXLS", method = RequestMethod.POST, produces = APP_JSON)
@ResponseBody
public void getCSV(final HttpServletResponse response, @RequestParam(value = "empId", required = true) final String empId) throws IOException, Exception
{
    final byte[] csv = ExportXLSUtil.getFileBytes(empId); // get the file bytes
    final OutputStream output = getOutputStream(response);
    response.setHeader("Content-Disposition", "attachment; filename=documents_" + new DateTime() + ".xls");
    response.setContentType(CONTENT_TYPE);
    response.setContentLength(csv.length);
    write(output, csv);
}