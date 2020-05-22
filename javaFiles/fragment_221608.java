@PostMapping("/export", produdes = MediaType.APPLICATION_JSON_VALUE)
@ResponseBody
public Object exportExcel(@RequestParam("paperId") String paperId, HttpServletResponse response) throws IOException {
    List<Answer> answerList = answerService.getData(paperId);
    InputStream excelFile = WriteExcel.writeData(answerList, "test", response);
    response.setHeader("Content-Disposition", "attachment; filename=Export" + LocalDate.now() + ".xlsx");
    response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
    FileCopyUtils.copy(excelFile, response.getOutputStream());
    response.flushBuffer();

}