public class ReportGenerator {
public static void main(String args[]) throws EngineException {
    ReportGenerator reportGenerator = new ReportGenerator();
    reportGenerator.executeReport();
}

public void executeReport() throws EngineException {

    IReportEngine engine=null;
    EngineConfig config = null;

    try{
        config = new EngineConfig( );           
        config.setBIRTHome("C:\\birt-rcp-report-designer-3_7_2\\ReportEngine");
        config.setLogConfig("c:/temp/test", Level.FINEST);
        Platform.startup( config );
        IReportEngineFactory factory = (IReportEngineFactory) Platform.createFactoryObject( IReportEngineFactory.EXTENSION_REPORT_ENGINE_FACTORY );
        engine = factory.createReportEngine( config );      

        IReportRunnable design = null;
        //Open the report design
        design = engine.openReportDesign("ReportTemplates/testNoData.rptdesign"); 
        IRunAndRenderTask task = engine.createRunAndRenderTask(design);
        task.setParameterValue("AuthorName", "Dale DeMott");
        HTMLRenderOption options = new HTMLRenderOption();      
        options.setOutputFileName("output/resample/Parmdisp.html");
        options.setOutputFormat("html");

        task.setRenderOption(options);

        //Connection helper is a utility class used to create a connection to your
        //database and return it.  
        ConnectionHelper connectionHelper = new ConnectionHelper();
        Connection conn = connectionHelper.getConnection();
        task.getAppContext().put("OdaJDBCDriverPassInConnection", conn);

        task.run();
        task.close();
        engine.destroy();
    } catch (Exception ex) {
        ex.printStackTrace();
    } finally {
        Platform.shutdown();
    }
}
}