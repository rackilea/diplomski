import java.awt.BorderLayout;
import java.util.HashMap;
import javax.swing.JFrame;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRPrintHyperlink;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.swing.JRViewer;
import net.sf.jasperreports.swing.JRViewerPanel;
import net.sf.jasperreports.view.JRHyperlinkListener;

public class HyperLinkTest extends JRViewer implements JRHyperlinkListener {

    private static final long serialVersionUID = -6429615130889276357L;

    public HyperLinkTest(JasperPrint jrPrint){
        super(jrPrint);
    }

    /**
     * Since JRViewerPanel is protected our only way to add listener is
     * to Override
     */
    @Override
    protected JRViewerPanel createViewerPanel()
    {
        JRViewerPanel panel =  new JRViewerPanel(viewerContext);
        panel.addHyperlinkListener(this);
        return panel;
    }

    /**
     * The listener gets the hyperlink reference and open relative report
     */
    @Override
    public void gotoHyperlink(JRPrintHyperlink arg) throws JRException {
        JasperReport report = JasperCompileManager.compileReport("jasper/" + arg.getHyperlinkReference() + ".jrxml");
        JasperPrint jasperPrint = JasperFillManager.fillReport(report, new HashMap<String, Object>());
        HyperLinkTest nextReport = new HyperLinkTest(jasperPrint);
        openReport("Navigated to", JFrame.DISPOSE_ON_CLOSE, nextReport);        
    }

    /**
     * static method that creates a frame and adds the JRViewer to it and 
     * open a new frame with the viewer
     */
    public static void openReport(String title, int defaultCloseOperation, JRViewer hyperLinkReport){
      SwingUtilities.invokeLater(new Runnable() {

        @Override
        public void run() {
            JFrame frame = new JFrame(title);
            frame.setDefaultCloseOperation(defaultCloseOperation);
            frame.getContentPane().setLayout(new BorderLayout());
            frame.getContentPane().add(hyperLinkReport,BorderLayout.CENTER);
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        }
      });
    }

    /**
     *  Main method to test
     */
    public static void main(String[] args) throws JRException {
        JasperReport report = JasperCompileManager.compileReport("jasper/hyperlink1.jrxml");
        JasperPrint jasperPrint = JasperFillManager.fillReport(report, new HashMap<String, Object>());
        HyperLinkTest test = new HyperLinkTest(jasperPrint);
        openReport("Test hyperlink", JFrame.EXIT_ON_CLOSE, test);

    }   

}