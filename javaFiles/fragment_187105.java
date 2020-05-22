class Player {

    float x, y;
    float w, h;
    float speedY = 0.0;
    color c;
    boolean move_up = false, move_down = false;

    //Constructor
    Player(float tempX, float tempY, float tempW, float tempH){

        x = tempX;
        y = tempY;
        w = tempW;
        h = tempH;
        c = (255);
    }

    void run() {
        display();
        move();
    }

    void display() {

        fill(c);
        rect(x, y-h/2, w, h);
        println(y);
    }

    void move() {
        if (!move_up && !move_down) {speedY *= 0.95;}
        if (move_up)                {speedY -= 0.1;}
        if (move_down)              {speedY += 0.1;}
        speedY = max(-5.0, min(5.0, speedY));
        y += speedY;
    }

    void pressed(boolean up, boolean down) {
        if (up)   {move_up   = true;}
        if (down) {move_down = true;}
    }

    void released(boolean up, boolean down) {
        if (up)   {move_up   = false;}
        if (down) {move_down = false;}
    }
}