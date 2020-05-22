public class Test extends javax.swing.JFrame {

   public Test() {
      initComponents();
   }

   @SuppressWarnings("unchecked")
   // <editor-fold defaultstate="collapsed" desc="Generated Code">
   private void initComponents() {

      jDesktopPane1 = new javax.swing.JDesktopPane();
      jPanel1 = new javax.swing.JPanel();
      jButton1 = new javax.swing.JButton();

      setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

      javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(
            jDesktopPane1);
      jDesktopPane1.setLayout(jDesktopPane1Layout);
      jDesktopPane1Layout.setHorizontalGroup(jDesktopPane1Layout
            .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 578, Short.MAX_VALUE));
      jDesktopPane1Layout.setVerticalGroup(jDesktopPane1Layout
            .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 367, Short.MAX_VALUE));

      jButton1.setText("OPEN");
      jButton1.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            jButton1ActionPerformed(evt);
         }
      });

      javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(
            jPanel1);
      jPanel1.setLayout(jPanel1Layout);
      jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(
            javax.swing.GroupLayout.Alignment.LEADING).addGroup(
            jPanel1Layout
                  .createSequentialGroup()
                  .addGap(136, 136, 136)
                  .addComponent(jButton1,
                        javax.swing.GroupLayout.PREFERRED_SIZE, 74,
                        javax.swing.GroupLayout.PREFERRED_SIZE)
                  .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE,
                        Short.MAX_VALUE)));
      jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(
            javax.swing.GroupLayout.Alignment.LEADING).addComponent(jButton1,
            javax.swing.GroupLayout.Alignment.TRAILING,
            javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE));

      javax.swing.GroupLayout layout = new javax.swing.GroupLayout(
            getContentPane());
      getContentPane().setLayout(layout);
      layout.setHorizontalGroup(layout
            .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE,
                  javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
      layout.setVerticalGroup(layout.createParallelGroup(
            javax.swing.GroupLayout.Alignment.LEADING).addGroup(
            layout.createSequentialGroup()
                  .addComponent(jDesktopPane1)
                  .addPreferredGap(
                        javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                  .addComponent(jPanel1,
                        javax.swing.GroupLayout.PREFERRED_SIZE,
                        javax.swing.GroupLayout.DEFAULT_SIZE,
                        javax.swing.GroupLayout.PREFERRED_SIZE)));

      pack();
   }// </editor-fold>

   private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
      jButton1.setEnabled(false);
      NewJInternalFrame nf = new NewJInternalFrame(this);  //!! 
      jDesktopPane1.add(nf);
      nf.show();
   }

   public static void main(String args[]) {

      try {
         for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager
               .getInstalledLookAndFeels()) {
            if ("Nimbus".equals(info.getName())) {
               javax.swing.UIManager.setLookAndFeel(info.getClassName());
               break;
            }
         }
      } catch (ClassNotFoundException ex) {
         java.util.logging.Logger.getLogger(Test.class.getName()).log(
               java.util.logging.Level.SEVERE, null, ex);
      } catch (InstantiationException ex) {
         java.util.logging.Logger.getLogger(Test.class.getName()).log(
               java.util.logging.Level.SEVERE, null, ex);
      } catch (IllegalAccessException ex) {
         java.util.logging.Logger.getLogger(Test.class.getName()).log(
               java.util.logging.Level.SEVERE, null, ex);
      } catch (javax.swing.UnsupportedLookAndFeelException ex) {
         java.util.logging.Logger.getLogger(Test.class.getName()).log(
               java.util.logging.Level.SEVERE, null, ex);
      }
      // </editor-fold>

      java.awt.EventQueue.invokeLater(new Runnable() {
         public void run() {
            new Test().setVisible(true);
         }
      });
   }

   // Variables declaration - do not modify
   private javax.swing.JButton jButton1; //!! make this private
   private javax.swing.JDesktopPane jDesktopPane1;
   private javax.swing.JPanel jPanel1;
   // End of variables declaration

   //!! added
   public void setButton1Enabled(boolean enabled) {
      jButton1.setEnabled(enabled);
   }
}

class NewJInternalFrame extends javax.swing.JInternalFrame {
   private Test test; //!!

   public NewJInternalFrame(Test test) { //!!
      this.test = test; //!!
      initComponents();
   }

   @SuppressWarnings("unchecked")
   // <editor-fold defaultstate="collapsed" desc="Generated Code">
   private void initComponents() {

      setClosable(true);
      setIconifiable(true);
      setMaximizable(true);
      setResizable(true);
      addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
         public void internalFrameActivated(
               javax.swing.event.InternalFrameEvent evt) {
         }

         public void internalFrameClosed(
               javax.swing.event.InternalFrameEvent evt) {
            formInternalFrameClosed(evt);
         }

         public void internalFrameClosing(
               javax.swing.event.InternalFrameEvent evt) {
         }

         public void internalFrameDeactivated(
               javax.swing.event.InternalFrameEvent evt) {
         }

         public void internalFrameDeiconified(
               javax.swing.event.InternalFrameEvent evt) {
         }

         public void internalFrameIconified(
               javax.swing.event.InternalFrameEvent evt) {
         }

         public void internalFrameOpened(
               javax.swing.event.InternalFrameEvent evt) {
         }
      });

      javax.swing.GroupLayout layout = new javax.swing.GroupLayout(
            getContentPane());
      getContentPane().setLayout(layout);
      layout.setHorizontalGroup(layout.createParallelGroup(
            javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 394,
            Short.MAX_VALUE));
      layout.setVerticalGroup(layout.createParallelGroup(
            javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 274,
            Short.MAX_VALUE));

      pack();
   }// </editor-fold>

   private void formInternalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
      //!! Test njf = new Test();
      //!! njf.jButton1.setEnabled(true);
      test.setButton1Enabled(true); //!! don't expose the button but a method
   }

}