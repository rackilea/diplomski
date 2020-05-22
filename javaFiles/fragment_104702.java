if (!enemiesDrawn) {
    setEnemies();

    g2.setColor(Color.BLUE);
    g2.setBackground(Color.BLUE);

    System.out.println("...");
    enemyShapes.forEach(g2::draw);

    enemiesDrawn = true;
}