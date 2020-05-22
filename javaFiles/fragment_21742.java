import javax.swing.UIManager;


public class NewJFrame extends javax.swing.JFrame {

/** Creates new form NewJFrame */
public NewJFrame() {
    try
    {
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
    }
    catch (Exception e) {    }

    initComponents();
}

.
. 
.
.
/**
* @param args the command line arguments
*/
public static void main(String args[]) {
    java.awt.EventQueue.invokeLater(new Runnable() {
        public void run() {
            new NewJFrame().setVisible(true);
        }
    });
}