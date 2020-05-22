Intersection inter = handleIntersection( bounds, start, end, radius );

if (inter != null) 
{
   // Project Future Position
   float remainingTime = 1.0f - inter.time;
   float dx = end.x - start.x;
   float dy = end.y - start.y;
   float dot = dx * inter.nx + dy * inter.ny;
   float ndx = dx - 2 * dot * inter.nx;
   float ndy = dy - 2 * dot * inter.ny;
   float newx = inter.x + ndx * remainingTime;
   float newy = inter.y + ndy * remainingTime;
   // new circle position = {newx, newy}
 }