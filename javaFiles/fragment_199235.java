main: for (Iterator<Ball> itBall = al.iterator(); itBall.hasNext();) {
    Ball ball = itBall.next();
    for (Iterator<Enemy> itEnemy = al2.iterator(); itEnemy.hasNext();) {
        Enemy enemy = itEnemy.next();
        if (ball.x == enemy.x && ball.y == enemy.y) {
            itBall.remove();
            itEnemy.remove();
            continue main;
        }
    }
}