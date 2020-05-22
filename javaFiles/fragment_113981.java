jWindowInstance.addKeyListener(new KeyAdapter() {
   public void keyReleased(KeyEvent e) {
      if(e.getKeyCode() == KeyEvent.VK_ENTER) {
         jWindowInstance.dispose(); // Release resources

         // OR
         jWindowInstance.setVisble(false); // Just hide the window so you can reuse it afterwards
      }
   }
});