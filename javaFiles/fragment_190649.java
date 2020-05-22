private <T extends ParentClass> boolean compareFiles(
    File created, 
    File template, 
    ReportType reportType, 
    Class<T> reportClass
) throws Exception {
   ...
   HeaderColumnNameTranslateMappingStrategy<T> strat = new HeaderColumnNameTranslateMappingStrategy<>();
   strat.setType(reportClass);
   ...