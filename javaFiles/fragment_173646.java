@Autowired @Qualifier("helloWorldReport2")
private JasperReportsPdfView helloReport;

@RequestMapping(value = "helloReport2", method = RequestMethod.GET)
public ModelAndView getRpt2(ModelAndView modelAndView) {
  Map<String, Object> parameterMap = new HashMap<>();
  parameterMap.put("datasource", new JREmptyDataSource());
  modelAndView = new ModelAndView(helloReport, parameterMap);
  return modelAndView;
}