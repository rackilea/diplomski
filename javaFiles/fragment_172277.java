@RequestMapping(value = "/getFullData2.html", method = RequestMethod.GET, consumes = "text/csv")
@ResponseBody // indicate to use a compatible HttpMessageConverter
public CsvResponse getFullData(HttpSession session) throws IOException {
      List<CompositeRequirement> allRecords = compReqServ.getFullDataSet((String) session.getAttribute("currentProject"));
      return new CsvResponse(allRecords, "yourData.csv");
}