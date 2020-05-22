Iterator<Bullet> bulletIterator = bullets.iterator();
while (bulletIterator.hasNext()) {
    Bullet bullet = bulletIterator.next();
    Iterator<Enemy> enemyIterator = enemies.iterator();
    while (enemyIterator.hasNext()) {
        Enemy enemy = enemyIterator.next();
        if (/* check if you have to remove the bullet */) {
            bulletIterator.remove();
        }
        if (/* check if you have to remove the enemy */) {
            enemyIterator.remove();
        }
    }
}