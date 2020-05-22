for (int x = hx/2; x<width; x+=hx) {
  for (int y = hy/2; y<height; y+=hy) {
    // horizontal
    int xs = x-hx/2, 
        ym = y+hy/2, 
        xe = x+hx/2;
    float x3, x4, y1, y2,
          x1 = x-5, 
          x2 = x+5;

    boolean up = random(1) < 0.5;
    x3 = x - random(5, 10);
    x4 = x + random(5, 10);
    if (up) {
      y1 = y+hy/2 - random(10, 20);
      y2 = y+hy/2 - random(10, 20);
    } else {
      y1 = y+hy/2 + random(10, 20);
      y2 = y+hy/2 + random(10, 20);
    } 

    curve(xs, ym, x1, ym, x3, y1, x4, y2);         
    curve(x1, ym, x3, y1, x4, y2, x2, ym);         
    curve(x3, y1, x4, y2, x2, ym, xe, ym);

    // vertical
    int ys = y-hy/2, 
        xm = x+hx/2, 
        ye = y+hy/2;

    y1 = y-5; 
    y2 = y+5; 

    float y3, y4;

    boolean left = random(1) < 0.5;
    y3 = y - random(5, 10);
    y4 = y + random(5, 10);
    if (left) {
      x1 = x+hx/2 - random(10, 20);
      x2 = x+hx/2 - random(10, 20);
    } else {
      x1 = x+hx/2 + random(10, 20);
      x2 = x+hx/2 + random(10, 20);
    }

    curve(xm, ys, xm, y1, x1, y3, x2, y4);         
    curve(xm, y1, x1, y3, x2, y4, xm, y2);         
    curve(x1, y3, x2, y4, xm, y2, xm, ye);         
  }
}