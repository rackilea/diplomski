//Create a base filler
JRBaseFiller filler = JRFiller.createFiller(DefaultJasperReportsContext.getInstance(),report);
//Fill the report
JasperPrint jasperPrint = filler.fill(map, connection);
//Get the variables / parameter from the filler
Object rc = filler.getVariableValue("REPORT_COUNT");
int count = 0;
if (rc instanceof Number){
  count = ((Number)rc).intValue();
}