long lastShoot = System.currentTimeMillis();
final long threshold = 500; // 500msec = half second

public void keyPressed(KeyEvent e) { 
  if (e.getKeyCode() == KeyEvent.VK_SPACE)
  {
     long now = System.currentTimeMillis();
     if (now - lastShoot > threshold)
     {
       shoot();
       lastShoot = now;
     }
  }
}