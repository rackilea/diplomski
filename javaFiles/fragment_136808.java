//initialize in create()
ArrayList<Ball> balls;


private void update(float dt) {
    //Pretty much saying 'For every ball in Balls, assign it to 'b' and do something with it
    for(Ball b : balls) {
        updateBall(b, dt);
    }
}
private void updateBall(Ball b, float dt) {
    b.Intergrate(dt);
    b.updateBounds();
    //------------------
    if(b.Left() < fieldLeft){
        b.move(fieldLeft, ball.getY());
        b.Reflect(true, false);
    }

    if(b.Right() > fieldRight){
        b.move(fieldRight - b.getWidth(), b.getY());
        b.Reflect(true, false);
    }

    if(b.Bottom() < fieldBottom){
        b.move(b.getX(), fieldBottom);
        b.Reflect(false, true);
    }

    if(b.Top() > fieldTop){
        b.move(b.getX(), fieldTop - b.getHeight());
        b.Reflect(false, true);
    }

}