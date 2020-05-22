Iterator<Enemy> enemiesIterator = enemies.iterator();
Iterator<Entity> bulletsIterator = bullets.iterator();
while (enemiesIterator.hasNext()) {
    Enemy nextEnemy = enemiesIterator.next();
    while(bulletsIterator.hasNext()) {
        Entity nextBullet = bulletsIterator.next();
        if (colliesWith(nextBullet, nextEnemy) {
            enemierIterator.remove();
            bulletsIterator.remove();
            addScore(1);
        }
    }
}