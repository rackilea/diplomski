if (ltime >= 0.0f && ltime <= 1.0f) {
   float ly = dy * ltime + start.y;
   if (ly >= T && ly <= B) {
      return new Intersection( dx * ltime + start.x, ly, ltime, -1, 0 );
   }
}
else if (rtime >= 0.0f && rtime <= 1.0f) {
   float ry = dy * rtime + start.y;
   if (ry >= T && ry <= B) {
      return new Intersection( dx * rtime + start.x, ry, rtime, 1, 0 );
   }
}

if (ttime >= 0.0f && ttime <= 1.0f) {
   float tx = dx * ttime + start.x;
   if (tx >= L && tx <= R) {
      return new Intersection( tx, dy * ttime + start.y, ttime, 0, -1 );
   }
}
else if (btime >= 0.0f && btime <= 1.0f) {
   float bx = dx * btime + start.x;
   if (bx >= L && bx <= R) {
      return new Intersection( bx, dy * btime + start.y, btime, 0, 1 );
   }
}