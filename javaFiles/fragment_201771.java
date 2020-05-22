int THRESHOLD = 4000; // 4 seconds
long lastChanged = 0; // timestamp
public void ballColorSwap(){
    // maybe call it here?
    if(System.currentTimeMillis() - lastChanged < THRESHOLD)
        return;
    int rnd = (int)(Math.random() * 4);
    if(rnd == 1){
        ballColor.set(Color.RED);
    }
    if(rnd == 2){
        ballColor.set(Color.BLUE);
    }
    if(rnd == 3){
        ballColor.set(Color.GREEN);
    }
    if(rnd == 4){
        ballColor.set(Color.YELLOW);
    }
    // set the timestamp
    lastChanged = System.currentTimeMillis();
}
private void drawBall(float dt) {
    ballRenderer.circle(ball.getX(), ball.getY(), 20);
    ballRenderer.setColor(ballColor);
}