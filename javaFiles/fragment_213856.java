for(int x = hx/2; x<width; x+=hx) {
  for(int y = hy/2; y<height; y+=hy) {
    // horizontal
    ellipse(x-5, y+hy/2, 2,2);
    ellipse(x+5, y+hy/2, 2,2);

    boolean up = random(1) < 0.5;
    if(up) {
      ellipse(x-random(5,10), y+hy/2 - random(10,20), 2,2);
      ellipse(x+random(5,10), y+hy/2 - random(10,20), 2,2);
    } else {
      ellipse(x-random(5,10), y+hy/2 + random(10,20), 2,2);
      ellipse(x+random(5,10), y+hy/2 + random(10,20), 2,2);
    } 

    // vertical
    ellipse(x+hx/2, y-5, 2,2);
    ellipse(x+hx/2, y+5, 2,2);
    boolean left = random(1) < 0.5;
    if(left) {
      ellipse(x+hx/2-random(10,20), y-random(5,10), 2,2);
      ellipse(x+hx/2-random(10,20), y+random(5,10), 2,2);
    } else {
      ellipse(x+hx/2+random(10,20), y-random(5,10), 2,2);
      ellipse(x+hx/2+random(10,20), y+random(5,10), 2,2);
    }       
  }
}