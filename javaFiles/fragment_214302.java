private int delay;
private Random random= new Random();

private void tick() {
    delay++;
    if(delay % (60 * 5) == 0)
        enemies.add(new Enemy(random.nextInt(your game width), random.nextInt(your game height));