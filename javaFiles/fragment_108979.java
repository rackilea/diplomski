JasperReport report = JasperCompileManager.compileReport("yourReport.jrxml");
JRBaseFiller filler = JRFiller.createFiller(DefaultJasperReportsContext.getInstance(),report); //we need the filler to get the variable value
JasperPrint print = filler.fill(map, connection);
Object rc = filler.getVariableValue("REPORT_COUNT");
Object maxRc = filler.getParameterValue("REPORT_MAX_COUNT");
if (rc instanceof Number && maxRc instanceof Number){
    if (((Number)rc).intValue()>=((Number)maxRc).intValue()){
        System.out.println("REPORT_MAX_COUNT HIT!!, doing something else...");
    }
}