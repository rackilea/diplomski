void setup() {
    size(700, 500);
    frameRate(20); // frame rate = 20 Hz
}

int sx=50;
int sy=50;
int dx=15;

void draw() {

    background(196);
    ellipse(sx,sy,20,20); 
    sx=sx+dx;

    if (sx >= width || sx <= 0 ){
        dx *= -1;
    }
}