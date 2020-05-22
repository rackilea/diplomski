import java.net.*;
import java.io.*;
public class fileserver extends javax.swing.JFrame {

 /** Creates new form fileserver */
ServerSocket  ss;
Socket s;
File fadd;
public fileserver() {
initComponents();
//this.pack();
this.setVisible(true);
jFileChooser2.setVisible(true);
jProgressBar1.setVisible(false);
jButton2.setVisible(true);
jLabel1.setVisible(false);
this.setSize(600,200);
try
{
ss=new ServerSocket(4444);
 System.out.println("Yesssss, No problem with My Server");
 conn();
  }
  catch(Exception e){}
  }

 @SuppressWarnings("unchecked")
  // //GEN-BEGIN:initComponents
  private void initComponents() {

 jFileChooser1 = new javax.swing.JFileChooser();
  jButton1 = new javax.swing.JButton();
 jButton2 = new javax.swing.JButton();
 jFileChooser2 = new javax.swing.JFileChooser();
 jProgressBar1 = new javax.swing.JProgressBar();
 jLabel1 = new javax.swing.JLabel();

setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
setTitle("Futuristic FileSharing (Server)");

 jButton1.setText("Browse File");
 jButton1.addActionListener(new java.awt.event.ActionListener() {
 public void actionPerformed(java.awt.event.ActionEvent evt) {
  jButton1ActionPerformed(evt);
  }
  });

  jButton2.setText("Send to User");
  jButton2.addActionListener(new java.awt.event.ActionListener() {
  public void actionPerformed(java.awt.event.ActionEvent evt) {
 jButton2ActionPerformed(evt);
 }
  });

  jFileChooser2.addActionListener(new java.awt.event.ActionListener() {
  public void actionPerformed(java.awt.event.ActionEvent evt) {
  jFileChooser2ActionPerformed(evt);
  }
  });

  jLabel1.setText("Sending…");

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout  (getContentPane());
  getContentPane().setLayout(layout);
layout.setHorizontalGroup(
layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
   .addGroup(layout.createSequentialGroup()
    .addGroup(layout.createParallelGroup     (javax.swing.GroupLayout.Alignment.TRAILING)
 .addGroup(layout.createSequentialGroup()
   .addContainerGap()
    .addComponent(jFileChooser2, javax.swing.GroupLayout.PREFERRED_SIZE,    javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
    .addGroup(layout.createSequentialGroup()
    .addGap(145, 145, 145)
   .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 122,     javax.swing.GroupLayout.PREFERRED_SIZE)
   .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 186, Short.MAX_VALUE)
    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 127,     javax.swing.GroupLayout.PREFERRED_SIZE)))
   .addContainerGap(171, Short.MAX_VALUE))
    .addGroup(layout.createSequentialGroup()
     .addGap(198, 198, 198)
     .addComponent(jLabel1)
     .addGap(18, 18, 18)
    .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE,          javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
      .addContainerGap(295, Short.MAX_VALUE))
    );
    layout.setVerticalGroup(
   layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
   .addGroup(layout.createSequentialGroup()
   .addGap(65, 65, 65)
    .addGroup(layout.createParallelGroup   (javax.swing.GroupLayout.Alignment.TRAILING)
   .addComponent(jButton2)
    .addComponent(jButton1))
    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
    .addGroup(layout.createParallelGroup   (javax.swing.GroupLayout.Alignment.LEADING)
    .addComponent(jLabel1)
    .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE,   javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11,   Short.MAX_VALUE)
    .addComponent(jFileChooser2, javax.swing.GroupLayout.PREFERRED_SIZE,    javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
  );

 pack();
  }// //GEN-END:initComponents

  private void jFileChooser2ActionPerformed(java.awt.event.ActionEvent evt)    {//GEN-FIRST:event_jFileChooser2ActionPerformed
 if(jFileChooser2.CANCEL_OPTION==1)
 {
jFileChooser2.setVisible(false);
  this.setSize(600, 200);
 jButton1.setEnabled(true);
  jButton2.setVisible(false);
  }
  fadd=jFileChooser2.getSelectedFile();
 jButton2.setVisible(true);
  //jButton1.setVisible(false);
  if((fadd==null)||(fadd.getName().equals("")))
 {
jFileChooser2.setVisible(false);
 this.setSize(600, 200);
    jButton1.setEnabled(true);
    jButton2.setVisible(false);
    }
   }//GEN-LAST:event_jFileChooser2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt)      {//GEN-FIRST:event_jButton1ActionPerformed
    jFileChooser2.setVisible(true);
 this.setSize(800, 500);
jButton1.setEnabled(false);
  }//GEN-LAST:event_jButton1ActionPerformed

  private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-       FIRST:event_jButton2ActionPerformed
   jProgressBar1.setVisible(true);
   jLabel1.setVisible(true);
   this.setSize(600,200);
    doit();
     }//GEN-LAST:event_jButton2ActionPerformed

     /**
    * @param args the command line arguments
     */
    public static void main(String args[]) {
     java.awt.EventQueue.invokeLater(new Runnable() {
    public void run() {
    new fileserver();
     }
     });

    }
    void doit(){
     try{
     jProgressBar1.setValue(10);
      byte [] mybytearray  = new byte [(int)fadd.length()];

     FileInputStream fis = new FileInputStream(fadd);
     BufferedInputStream bis = new BufferedInputStream(fis);

   bis.read(mybytearray,0,mybytearray.length);
    OutputStream os = s.getOutputStream();
     jProgressBar1.setValue(20);
    ObjectOutputStream snd=new ObjectOutputStream(os);
      jProgressBar1.setValue(30);
    msg m=new msg();
     System.out.println("Sending…");
     jProgressBar1.setValue(40);
    m.setarray(mybytearray);
    jProgressBar1.setValue(50);
     m.setname(fadd.getName());
     jProgressBar1.setValue(70);

    snd.writeObject(m);
   snd.flush();
   System.out.println("Done…");
    jProgressBar1.setValue(100);
     }
    catch(Exception i){
   System.out.println("\nChal bhag Kaam nai Hua!");
    }
     }
     void conn(){
         try{
          System.out.println("Pending request (Server)");
         s=ss.accept();
       }
        catch(Exception e){
       System.out.println("Error in connection"+e);}
       }
     // Variables declaration – do not modify//GEN-BEGIN:variables
       private javax.swing.JButton jButton1;
      private javax.swing.JButton jButton2;
    private javax.swing.JFileChooser jFileChooser1;
        private javax.swing.JFileChooser jFileChooser2;
     private javax.swing.JLabel jLabel1;
    private javax.swing.JProgressBar jProgressBar1;
   // End of variables declaration//GEN-END:variables
   }
   class msg1 implements Serializable
    {
  boolean flag;
  int size;
  String name;
  byte[] mess;

  msg1(){
  flag=false;
  size=0;
 name="Server";
  }

 void setarray(byte[] b){
 mess=b;
 }

  void setname(String str){
  name=str;
   }

 byte[] getarray(){
 return(mess);
 }

 String getname(){
 return(name);
 }
}