int scale = 10;
for (int x = 0; x <= 4; x++) {
    p.addPoint(w+scale*x, h - scale*((x*x*x) + x - 3));
}
//...lines skipped
for (int x = -10; x <= 10; x++) {
  p1.addPoint(w + scale*x, h - scale*((x*x*x)/100) - x + 10);
}