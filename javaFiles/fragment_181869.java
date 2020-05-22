List<Bullet> bullets = new ArrayList<Bullet>();

public void entityLogic(GameContainer gc, int deltaTime) {
  // since this method is called many times you should shoot a bullet just every X msec
  if (spacebar pressed) {
    // you spawn a new bullet according to player position
    Bullet bullet = new Bullet(player.x,player.y);
    // you add it to the list
    bullets.add(bullet);
  }

  // destroy bullets which are outside the viewport
  for (int i = 0; i < bullets.size(); ++i) {
    Bullet bullet = bullets.get(i);
    if (bullet.isOutsideBounds()) {
      bullets.remove(i);
      i--;      
    }
}

public void entityRendering(Graphics g) {
  for (Bullet bullet : bullets)
    bullets.entityRenering(g);
}
  }