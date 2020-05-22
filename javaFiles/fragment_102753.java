class JButtonImageListener implements ImageListener {
   private JButton button; //plus getter/setter

   public void imageChanged(ImageEvent e) {
     button.setEnabled(e.isImageLoaded());
   }
}