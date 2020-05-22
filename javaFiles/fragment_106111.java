void draw() {

    capSize = 20;
    x1 = 30;
    crossWidth = width - (30*2);
    y1 = height - 20;
    crossHeight = 20;
    capX = x1;
    capY = y1 + crossHeight/2;
    capX2 = width - x1;
    diffY = 60;
    diffX = 10;
    redLinex = 145;
    redLinex2 = 350;
    redLiney = 0;
    redlineHeight = height;
    redlineWidth = 5;

    background(200);
    drawConvergingvertical();
    horizontalCross();
    drawYellowlines();
    if (mousePressed) {
        drawRedlines();
    }
}