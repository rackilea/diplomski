float ltime = Float.MAX_VALUE;
float rtime = Float.MAX_VALUE;
float ttime = Float.MAX_VALUE;
float btime = Float.MAX_VALUE;

if (start.x - radius < L && end.x + radius > L) {
   ltime = ((L - radius) - start.x) / dx;
}
if (start.x + radius > R && end.x - radius < R) {
   rtime = (start.x - (R + radius)) / -dx;
}
if (start.y - radius < T && end.y + radius > T) {
   ttime = ((T - radius) - start.y) / dy;
}
if (start.y + radius > B && end.y - radius < B) {
   btime = (start.y - (B + radius)) / -dy;
}