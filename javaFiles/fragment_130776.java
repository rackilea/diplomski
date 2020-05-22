Random random = new Random();
int yellowBrick = random.nextInt(5);
for (int i = 0; i < 5; i++) {
    Color color = i == yellowBrick ? Color.YELLOW : Color.BLUE;
    GameObj brick = new GameObj(i*100, 100, BRICK_WIDTH, BRICK_HEIGHT, color);
    brick.moveX(75);
    brick.visible = true;
    bricks.add(brick);
    System.out.println("Model:: Create Brick =" + brick);
}