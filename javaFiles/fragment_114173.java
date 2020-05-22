static boolean anyEnemyCollides(Player player, List<Enemy> enemies) {
    for  (Enemy enemy : enemies) {
        if  (player.intersect(enemy)) {
            return true;
        }
    }
    return false;
}