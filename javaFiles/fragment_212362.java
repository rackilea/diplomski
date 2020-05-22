public class Frame extends javax.swing.JFrame {

Dialog d = new Dialog(this, true);

public Frame(){
    setTitle("Frame");
    initComponents();
    setResizable(false);
}

void buttonDisable(){
    Btn1.setEnabled(false);
}

private void Btn1ActionPerformed(java.awt.event.ActionEvent evt) {                                     
    d.setVisible(true);
}                                    

public static void main(String args[]) {

    java.awt.EventQueue.invokeLater(new Runnable() {
        @Override
        public void run() {
            new Frame().setVisible(true);
        }
    });
}
// Variables declaration - do not modify                     
public javax.swing.JButton Btn1;
// End of variables declaration                   
}