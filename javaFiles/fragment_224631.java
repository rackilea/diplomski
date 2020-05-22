import de.professional_webworkx.dashboard.frame.MainFrame;
import javax.swing.SwingUtilities;

public class Dashboard {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                new MainFrame();
            }
        });
    }    
}