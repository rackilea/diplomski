Public class newDisability extends javax.swing.JFrame {
public String name= "ooo";
public boolean flag=false;
private disability dis;

 public newDisability(disability d)
 {
   this.dis=d;
 }

 // The Button that creates the new disability and closes this window
 private void createActionPerformed(java.awt.event.ActionEvent evt) {
    name= (String) jTextField1.getText();
    flag=true;
    this.dis.setName(name);
    this.dispose();
 }
}