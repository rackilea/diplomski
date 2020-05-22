if (player.getHealth() < 0) {
// player bitmap disappears
dissapear = true;
//game ends
gameEnded=true;
explosion = new Explosion(BitmapFactory.decodeResource(getResources(),   
R.drawable.images),player.getX(),player.getY()-10,9,9,25);
}

if (dissapear){explosion.animating();}