public void reportviewer() {
    // Disable any UI components you don't want the user using while
    // the report generates...
    new ReportWorker().execute();
}

public class ReportWorker extends SwingWorker<JasperPrint, Void> {

    @Override
    protected JasperPrint doInBackground() throws Exception {
        String report = "C:\\Users\\cleanfuel\\Documents\\NetBeansProjects\\StringManipulation\\src\\stringmanipulation\\report1.jrxml";
        JasperReport jasp_report = JasperCompileManager.compileReport(report);
        JasperPrint jasp_print = JasperFillManager.fillReport(jasp_report, null, getConnection());
        return jasp_print;
    }

    @Override
    protected void done() {
        try {
            JasperPrint jasp_print = get();
            JasperViewer.viewReport(jasp_print);
        } catch (Exception exp) {
            exp.printStackTrace();
        }
        // Renable any UI components you disabled before the report run
    }
}