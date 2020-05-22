for ( int i = 0; player.length < i; i++){
    player[i].draw(canvas);
    player[i].move();
}
...
for (int i = 0; i < player.length - 1; i++) {
    if (player[i].getX() > player[i + 1].getX() - 5 && 
        player[i].getX() < player[i + 1].getX() + 5 && 
        player[i].getY() > player[i + 1].getY() - 5 && 
        player[i].getY() < player[i + 1].getY() + 5) {

    // Do your update here!
    // You may need to create other methods...or you can just
    // create random X & Y for the player.
}