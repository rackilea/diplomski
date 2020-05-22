final int shotX = shot.x;
final int shotY = shot.y;
final int shotWidth = ?
final int shotHeight = ?
for(byte k = 0; k < enemies.length; k++) {
    final int enemyX = enemies[k].pos.x;
    final int enemyY = enemies[k].pos.y;
    final int enemyWidth = enemies[k].getTexture().getImageWidth();
    final int enemyHeight = enemies[k].getTexture().getImageHeight();

    if(     shotX < enemyX + enemyWidth &&
            shotX + shotWidth < enemyX &&

            shotY < enemyY + enemyHeight &&
            shotY + shotHeight < enemyY) {

        Main.enemies[k].hit = true;
    }
}