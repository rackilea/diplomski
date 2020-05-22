public class Dialog extends javax.swing.JDialog {

private Frame parentFrame;
public Dialog(Frame parent, boolean modal) {
    super(parent, modal);
    initComponents();
    setTitle("Dialog");

    this.parentFrame=parent;//hold reference to the parent

    this.setVisible(true);
}                      

private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                         
    this.parentFrame.buttonDisable();//invoke method on the parent reference 
    dispose();
}                                        


// Variables declaration - do not modify                     
private javax.swing.JButton jButton1;
// End of variables declaration                   
}