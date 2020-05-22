private static final String FILENAME = "fileName.xls";


@PostMapping(value = "/reports/tasks/allTasks.xlsx", produces=MediaType.APPLICATION_OCTET_STREAM_VALUE)
public void reportExcelTasks(@RequestParam("fromDate") String fromDate, @RequestParam("toDate") String toDate, HttpServletResponse response) throws IOException {

LocalDateTime startDate = DateTimeUtils.convertStringToLocalDateTime(fromDate);
LocalDateTime endDate = DateTimeUtils.convertStringToLocalDateTime(toDate);

List<ReportTaskToTimeResponse> list = reportService.getTaskOfMemberToTime(startDate, endDate);

    ByteArrayInputStream in = ReportExcel.tasksToExcel(list);
    IOUtils.copy(in, response.getOutputStream());
    response.setContentType("application/x-download");
    response.setHeader("Content-Disposition", "attachment; filename=" + java.net.URLEncoder.encode(FILENAME, "UTF-8"));
    response.flushBuffer();
}