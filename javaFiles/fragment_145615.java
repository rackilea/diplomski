import java.util.logging.Level;

import org.eclipse.birt.core.framework.Platform;
import org.eclipse.birt.report.engine.api.EXCELRenderOption;
import org.eclipse.birt.report.engine.api.EngineConfig;
import org.eclipse.birt.report.engine.api.EngineConstants;
import org.eclipse.birt.report.engine.api.EngineException;
import org.eclipse.birt.report.engine.api.HTMLRenderOption;
import org.eclipse.birt.report.engine.api.HTMLServerImageHandler;
import org.eclipse.birt.report.engine.api.IReportEngine;
import org.eclipse.birt.report.engine.api.IReportEngineFactory;
import org.eclipse.birt.report.engine.api.IReportRunnable;
import org.eclipse.birt.report.engine.api.IRunAndRenderTask;
import org.eclipse.birt.report.engine.api.PDFRenderOption;
import org.eclipse.birt.report.engine.api.RenderOption;
import org.eclipse.birt.report.engine.api.impl.RunAndRenderTask;
import org.eclipse.birt.report.engine.api.script.IReportContext;


public class RunAndRenderTaskTest {

public void runReport() throws EngineException
{

RunAndRenderTask task=null;
IReportEngine engine=null;
EngineConfig config = null;

try{
config = new EngineConfig( );   
//config.setLogConfig("c:/dwn", Level.SEVERE);
//config.setResourcePath("C:/work/workspaces/3.7.1workspaces/BIRT 
Metal/APIs/resources");
Platform.startup( config );

IReportEngineFactory factory = (IReportEngineFactory) Platform
.createFactoryObject( 
IReportEngineFactory.EXTENSION_REPORT_ENGINE_FACTORY );
engine = factory.createReportEngine( config );


IReportRunnable design = null;
//Open the report design

design = engine.openReportDesign("Reports/testlibrary.rptdesign");
task = (RunAndRenderTask) engine.createRunAndRenderTask(design);    
IReportContext irc = task.getReportContext();
//task.setParameterValue("Top Count", (new Integer(5)));
//task.validateParameters();


//HTMLRenderOption options = new HTMLRenderOption();    
//options.setImageDirectory("./");
//options.setOutputFileName("output/resample/external.html");
//options.setOutputFormat("html");
//options.setEmbeddable(false);
//options.setEnableMetadata(true);
//options.setEnableInlineStyle(false);
//options.setEnableAgentStyleEngine(true);
//options.setEnableCompactMode(true);

//PDFRenderOption options = new PDFRenderOption();
//options.setOutputFileName("output/resample/hidefooter.pdf");
//options.setSupportedImageFormats("PNG;GIF;JPG;BMP;SWF;SVG");
//options.setOutputFormat("pdf");

//EXCELRenderOption options = new EXCELRenderOption();  
//options.setOutputFormat("xls");
//options.setOutputFileName("output/resample/customers.xls");
//options.setWrappingText(true);

HTMLRenderOption options = new HTMLRenderOption();
//options.setImageHandler(new HTMLServerImageHandler());
options.setSupportedImageFormats("JPG;PNG;BMP;SVG;GIF");
options.setOutputFileName("output/resample/testlibrary.html");
options.setOutputFormat("html");
//options.setOutputFormat("ppt");



task.setRenderOption(options);
task.run();

irc = task.getReportContext();

task.close();
engine.destroy();
}catch( Exception ex){
ex.printStackTrace();
}   
Platform.shutdown( );
System.out.println("Finished");



}   


/**
* @param args
*/
public static void main(String[] args) {
try
{

RunAndRenderTaskTest ex = new RunAndRenderTaskTest( );
ex.runReport();

System.exit(0);

}
catch ( Exception e )
{
e.printStackTrace();
}
}
}