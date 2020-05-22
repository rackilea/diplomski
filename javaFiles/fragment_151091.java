void draw () {

    background (255);

    int gridW = width/n_part;
    int gridH = height/n_part;

    strokeWeight(1);
    stroke(210);
    noFill();
    for (int row = 0; row < n_part; row++){ 
        int gridY = 0 + row*gridH;
        for (int col = 0; col < n_part; col++) {
            int gridX = 0+ col* gridW;
            rect (gridX, gridY, gridW, gridH);   
        }
    }

    stroke(0, 0, 0);
    fill(0);
    for (int i = 0; i < points.size(); ++ i) {
        Point p = points.get(i);
        p.Draw();
    }

    strokeWeight(3);
    stroke(255, 0, 0);
    for (int i = 0; i < points.size(); ++ i) {
        Point p1 = points.get(i);
        Point p2 = points.get((i+1) % points.size());
        line(p1.x, p1.y, p2.x, p2.y);   
    }
}