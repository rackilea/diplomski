public void keyTyped(KeyEvent arg0) {
   if(arg0.getKeyCode() == KeyEvent.VK_UP)
   {
       synchronized(player)
       {
          player.setDy(-5);
       }
   }
}