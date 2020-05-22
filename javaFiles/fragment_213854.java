int hx = width/4;
int hy = height/4;
for(int x = hx; x<width; x+=hx) {
  line(x,0,x,height);
  for(int y = hy; y<height; y+=hy) {
    line(0,y,width,y);
  }
}