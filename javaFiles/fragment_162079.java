double prevX = -450;
double prevY = 50 * Math.sin((prevX+offset) * (Math.PI / 180)); // seed the previous Y to start
for (double x = 0; x <= 450; x += 3) {
    double y = 50 * Math.sin((x+offset) * (Math.PI / 180));
    StdDraw.line(450 + (int)prevX, 350 - (int)prevY, 450 + (int)x, 350 - (int)y);
    prevX = x;
    prevY = y;
}