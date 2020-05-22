for (int i = 0; i < Constants.LIVES_START; i++) {
    if (worldController.lives <= i) 
        batch.setColor(0.5f, 0.5f, 0.5f, 0.5f);
    batch.draw(Assets.instance.bunny.head, x + i * 50, y, 50, 50, 120, 100, 0.35f, -0.35f, 0);
    batch.setColor(1, 1, 1, 1);
}