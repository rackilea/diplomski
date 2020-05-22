for(int i = 0; i < polen.size; i++) {
  Polen pol= polen.get(i);

  if(pol.collides(aliado.getBounds()) && !pol.isExploded()) {
    pol.changeExplosion();
    flagScore = 1;
  }
  else if (!pol.collides(aliado.getBounds())) {
    flagScore = 0;
  }
}