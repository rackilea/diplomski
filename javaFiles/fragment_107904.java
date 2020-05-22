for (k = 1; k <= 50; k++)  {
    for (x = 1; x <= 50; x+=20) {
        // Choose one of the following
        g.drawLine(20+k,150,20+x,525);
        g.drawLine(20+x,150,20+k,525);
    }
}