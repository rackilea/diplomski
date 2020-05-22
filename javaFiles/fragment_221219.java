public void reportviewer() {
    try{
        String report = "C:\\Users\\cleanfuel\\Documents\\NetBeansProjects\\StringManipulation\\src\\stringmanipulation\\report1.jrxml";
        JasperReport jasp_report = JasperCompileManager.compileReport(report);
        JasperPrint jasp_print = JasperFillManager.fillReport(jasp_report, null, getConnection());
        JasperViewer.viewReport(jasp_print);
    } catch (Exception e) {
        e.printStackTrace();
    }
}