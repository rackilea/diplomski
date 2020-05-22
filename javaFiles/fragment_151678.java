// Add these lines just before your first "addKeyListener"
for (KeyListener lsnr : serials.getKeyListeners()) {
  if(lsnr.getClass().getSimpleName().equals("Handler")){
    serials.removeKeyListener(lsnr);
  }
}