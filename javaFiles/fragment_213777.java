import java.io.ByteArrayOutputStream;
import java.util.Collection;
import java.util.Iterator;
import org.eclipse.birt.core.framework.Platform;
import org.eclipse.birt.report.engine.api.EngineConfig;
import org.eclipse.birt.report.engine.api.EngineException;
import org.eclipse.birt.report.engine.api.HTMLRenderOption;
import org.eclipse.birt.report.engine.api.IGetParameterDefinitionTask;
import org.eclipse.birt.report.engine.api.IParameterDefnBase;
import org.eclipse.birt.report.engine.api.IParameterGroupDefn;
import org.eclipse.birt.report.engine.api.IParameterSelectionChoice;
import org.eclipse.birt.report.engine.api.IReportEngine;
import org.eclipse.birt.report.engine.api.IReportEngineFactory;
import org.eclipse.birt.report.engine.api.IReportRunnable;
import org.eclipse.birt.report.engine.api.IRunAndRenderTask;
import org.eclipse.birt.report.engine.api.IScalarParameterDefn;
import org.eclipse.birt.report.engine.api.PDFRenderOption;

public class BirtEngine {

    IReportEngine engine = null;
    EngineConfig config = null;

    public BirtEngine()
    {
        try {
            config = new EngineConfig( );
            config.setBIRTHome("C:\\birtruntime\\ReportEngine");
            Platform.startup( config );
            IReportEngineFactory factory = (IReportEngineFactory) Platform.createFactoryObject( IReportEngineFactory.EXTENSION_REPORT_ENGINE_FACTORY );
            engine = factory.createReportEngine( config );
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public void openReport(String report)
    {
        try {
      IReportRunnable design = null;
            design = engine.openReportDesign(report);
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }

    public void renderReport(String report)
    {
        try {
      IReportRunnable design = null;
            design = engine.openReportDesign(report);
            IRunAndRenderTask task = engine.createRunAndRenderTask(design);
            HTMLRenderOption options = new HTMLRenderOption();
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            options.setOutputStream(bos);
            options.setOutputFormat("html");
            options.setEmbeddable(true);
            task.setRenderOption(options);
            task.run();
            task.close();
            //TreeBirtFrameView.jEditorPane1.setContentType("text/html");
            //TreeBirtFrameView.jEditorPane1.setText(bos.toString());
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }

    public void printReport(String report)
    {
        try {
      IReportRunnable design = null;
            design = engine.openReportDesign(report);
            IRunAndRenderTask task = engine.createRunAndRenderTask(design);
            PDFRenderOption options = new PDFRenderOption();
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            options.setOutputStream(bos);
            options.setOutputFormat("pdf");
            task.setRenderOption(options);
            task.run();
            task.close();
      //Runtime.getRuntime().exec("\\\\myServer\\pgms$\\Adobe\\Reader 9.0\\Reader\\acrord32.exe report.pdf");
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }

    public void stopPlatform()
    {
        engine.destroy();
        Platform.shutdown();
    }
}