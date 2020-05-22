float x;
float easing = 1;
float circle_x = 1;
float circle_y = 30;
float rad = 12.5;
float gravity = 0.98;
float move_x = 5;
float move_y = 5;

void setup() {
    size(640, 480);
    frameRate(60);
}

void draw() {
    background(#87CEEB);

    fill(#7cfc00);
    rect(0, 430, 640, 80);

    float targetX = mouseX;
    float dx = targetX - x;
    x += dx * easing;

    circle_x = circle_x + move_x;
    circle_y = circle_y + move_y;
    if (circle_x > width) {
        circle_x = width;
        move_x = -move_x;
    }
    else if (circle_x < 0) {
        circle_x = 0;
        move_x = -move_x;
    }

    int objW = 70;
    int objH = 390;
    int circleR = 25/2;
    if (circle_x > x && circle_x < x + objW && circle_y > objH-circleR ) {
        circle_y = objH-circleR;
        move_y = -move_y; 
    }
    else if (circle_y > height) {
        circle_y = height;
        move_y = -move_y;
    }
    else if (circle_y < 0) {
        circle_y = 0;
        move_y= -move_y;
    }

    fill(#000000);
    rect(x, 400, 30, 30);
    rect(x-20, 390, 70, 10);
    rect(x, 430, 5, 20);
    rect(x+25, 430, 5, 20);

    ellipse(circle_x, circle_y, 25, 25);
}