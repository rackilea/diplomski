EventQueue.invokeLater(new Runnable() {

   @Override
     public void run() {
         someComponent.grabFocus();
         someComponent.requestFocus();//or inWindow depends if Swing or Awt
     }
});