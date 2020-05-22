public class KeyBoard extends javax.swing.JDialog {

    /**
     * Creates new form KeyBoard
     */
    public KeyBoard(java.awt.Frame parent, boolean modal) {
        super(null, modal);

        this.frame = parent;

        setFocusableWindowState(false);
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        initComponents();
    }

    //Here are the other methods...

    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private java.awt.Frame frame;
}