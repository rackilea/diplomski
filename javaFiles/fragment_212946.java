import javax.swing.JDialog;

public class ColorManager extends JDialog {
    private static final long serialVersionUID = 1L;

    public ColorManager(){
        super();
         SwingUtilities.invokeLater(new Runnable() {
             public void run() {
                this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
                this.pack();
                this.setVisible(true);
             }
         });
    }
}