//On each frame
Update() {
vyUpdated = false;

//other game logic
...
// ball hits brick
for (int i = 0; i < bricks.size();i++){
    if ((ball.getBounds().intersects(bricks.get(i).getBounds()) 
    && (!bricks.get(i).getHit()))){
        bricks.get(i).Hit();
        bricks.get(i).Isvisible();
        if (!vyUpdated)
            vy = (vy * -1);
        vyUpdated = true;
        scorein ++;
    }
}