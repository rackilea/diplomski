private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
   jButton1.setEnabled(false);
   NewJInternalFrame nf = new NewJInternalFrame();
   jDesktopPane1.add(nf);
   nf.show();

   // !! do all this in the calling code
   nf.addInternalFrameListener(new InternalFrameAdapter() {

      @Override
      public void internalFrameClosed(InternalFrameEvent arg0) {
         jButton1.setEnabled(true);
      }

   });
}