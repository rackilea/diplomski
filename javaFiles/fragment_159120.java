@Override
public void gotoHyperlink(JRPrintHyperlink arg) throws JRException {
    Map<String, Object> nextReportParams = new HashMap<>();
    List<JRPrintHyperlinkParameter> params = arg.getHyperlinkParameters().getParameters();
    for (JRPrintHyperlinkParameter jphlp : params) {
        if ("reportTime".equals(jphlp.getName())){
            nextReportParams.put("previousReportTime",jphlp.getValue());                
        }
    }

    JasperReport report = JasperCompileManager.compileReport("jasper/" + arg.getHyperlinkReference() + ".jrxml");
    JasperPrint jasperPrint = JasperFillManager.fillReport(report, nextReportParams);
    HyperLinkTest nextReport = new HyperLinkTest(jasperPrint);
    openReport("Navigated to", JFrame.DISPOSE_ON_CLOSE, nextReport);        
}