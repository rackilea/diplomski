Image enemy;
    int enemyX = 800;
    int enemyY = 500;
    Random random = new Random();
    int RandomX = random.nextInt(1500);
    int RandomY = random.nextInt(1000);

...

public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
        //draw things
        ...
        Point enemyLoc = game.getEnemy().getLocation();
        enemy.draw(enemyLoc.x, enemyLoc.y);
}
//UPDATE FUNCTION
public void ???(game, ???) {
    ...
    //update OUTSIDE of render function
    if(game.getEnemy().isTouched()) {
        game.getEnemy().setLocation(random.nextInt(1500), random.nextInt(1000));
    }
    ...
}