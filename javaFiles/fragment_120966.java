width = x2 - x1;
for(int i = 0; i < width; i++) {
    float x = x1 + i;
    float y = y1 + (ratio * i);
    points.add(new Point(x,y));
}