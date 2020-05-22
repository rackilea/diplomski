double offset = 0;
    while (true) {
        offset+=1; // move the frame slightly
        StdDraw.show(10); // defer repainting for 10 milisecoinds

        StdDraw.clear(); // clear before painting

        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.line(0,350,900,350); // x-axis
        StdDraw.line(450,0,450,900); // y-axis
        StdDraw.setPenColor(StdDraw.RED);

        for (double x = -450; x <= 450; x += 0.5) {
            // apply the offset inside of calculation of Y only such that it 
            // slowly "moves" the sin wave
            double y = 50 * Math.sin((offset+x) * (Math.PI / 180));
            int Y = (int) y;
            int X = (int) x;
            StdDraw.line(450 + X, 350 - Y, 450 + X, 350 - Y);
        }

        StdDraw.show(); // end animation frame. force a repaint 
    }