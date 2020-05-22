void draw() {
    background(255);
    grid();

    // draw the lines in a loop 
    strokeWeight(3);
    stroke(0, 0, 255);
    for (int i = 0; i < BallNum; ++ i) {
        int i2 = (i+1) % BallNum;
        line(position[i].x, position[i].y, position[i2].x, position[i2].y); 
    }

    // draw balls in a loop
    strokeWeight(1);
    stroke(0, 0, 0);
    fill (255, 0, 0);
    for (int i = 0; i < BallNum; ++i) {
        circle(position[i].x, position[i].y, 10);
    }
}