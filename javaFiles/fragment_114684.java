int objX1 = -20;
int objX2 = 70;
int objH = 390;
int circleR = 25/2;
if (circle_x > x + objX1  && circle_x < x + objX2 && circle_y > objH - circleR ) {
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