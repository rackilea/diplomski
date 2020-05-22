for(int x = hx/2; x<width; x+=hx) {
  for(int y = hy/2; y<height; y+=hy) {
    ellipse(x + hx/2,y,5,5);
    ellipse(x,y + hy/2,5,5);
  }
}