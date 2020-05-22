public void keyPressed(KeyEvent k) {    
    if(k.getKeyCode() == KeyEvent.VK_LEFT) {
      if (basket.getX() > 0)  { 
        basket.move(-BM, 0); 
      } 
    }

    if(k.getKeyCode() == KeyEvent.VK_RIGHT) {
      if (basket.getX() + BW <  AW) { 
        basket.move(BM, 0); 
      } 
    }  
}