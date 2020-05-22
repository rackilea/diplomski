addWindowListener(new WindowAdapter() {

   @Override
   public void windowClosing(WindowEvent e) {
     Sound.gameSound.stop();
   }
});