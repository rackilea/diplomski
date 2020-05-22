public static void main(String[] args) {
    StdDraw.setXscale(0,900);
    StdDraw.setYscale(0,700);

    double offset = 0;
    while (true) {
        StdDraw.show(10);
        StdDraw.clear();
        offset-=1;

        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.line(0,350,900,350); // x-axis
        StdDraw.line(450,0,450,900); // y-axis
        StdDraw.setPenColor(StdDraw.RED);


        double prevX = 0;
        double prevY = 50 * Math.sin((prevX+offset) * (Math.PI / 180)); // seed the previous Y to start
        StdDraw.filledCircle(450 + prevX, 350 - prevY, 5);

        for (double x = 0; x <= 450; x += 3) {
            double y = 50 * Math.sin((x+offset) * (Math.PI / 180));
            StdDraw.line(450 + (int)prevX, 350 - (int)prevY, 450 + (int)x, 350 - (int)y);
            prevX = x;
            prevY = y;
        }
        StdDraw.show();

    }
}