public class MyJRViewer extends JRViewer {
    //define the constructor that you use
    public MyJRViewer(JasperPrint jasperPrint) {
        super(jasperPrint);
    }

    @Override
    protected JRViewerToolbar createToolbar() {
        JRViewerToolbar toolbar = super.createToolbar();

        Locale locale = viewerContext.getLocale();
        ResourceBundle resBundle = viewerContext.getResourceBundle();
        JRPdfSaveContributor pdf = new JRPdfSaveContributor(locale, resBundle);
        JRRtfSaveContributor rtf = new JRRtfSaveContributor(locale, resBundle);
        JRSingleSheetXlsSaveContributor xls = new JRSingleSheetXlsSaveContributor(locale, resBundle);
        JRDocxSaveContributor docx = new JRDocxSaveContributor(locale, resBundle);
        toolbar.setSaveContributors(new JRSaveContributor[] {pdf, rtf, xls, docx});

        return toolbar;
    }   
}