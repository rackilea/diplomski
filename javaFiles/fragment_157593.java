import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;

public class QuickCompile {

    public static void main(String[] args) {
        try {
            String template = "...";
            String compiled = "...";
            JasperCompileManager.compileReportToFile(template, compiled);

            // Just as a test...
            JasperReport jr = (JasperReport) JRLoader.loadObjectFromFile(compiled);            

        } catch (JRException exp) {
            exp.printStackTrace();
        }            
    }

}