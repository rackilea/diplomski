package test;
import javax.swing.SwingUtilities;
public class form1 extends javax.swing.JFrame {
private form2 click = null; // this will hold the second JFrame (the one with the checkbox)
public form1() {
    initComponents();
}                                      
private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
  if (click == null) { // only create the second JFrame once
      click = new form2(); // this stores the second JFrame with the name "click"
      click.setVisible(true);
  }
}
private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {                                         
            SwingUtilities.invokeLater(
            new Runnable() {
            public void run() {
                if (click != null) { // don't do anything if the second JFrame isn't displayed yet
                    click.jCheckBox1.setSelected(true);
                }
            }
        }
    );
}                                        
public static void main(String args[]) {
    java.awt.EventQueue.invokeLater(new Runnable() {
    public void run() {
    new form1().setVisible(true);
    }
    });
}  
// Variables declaration - do not modify                     
private javax.swing.JButton jButton1;
private javax.swing.JButton jButton2;
// End of variables declaration                  
}