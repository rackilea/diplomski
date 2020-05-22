boolean intersects=false, is_tangent=false;
double p2p1x=p2x-p1x, p2p1y=p2y-p1y;
double p1p2DistSq=p2p1x*p2p1x+p2p1y*p2p1y;
if(p1p2DistSq > 1e-12) { // well-behaved line 
  double p1cx=p1x-cx, p1cy=p1y-cy;
  double crossprod=p2p1x*p1cy-p2p1y*p1cx;
  double distCenterToLineSquare=crossprod*crossprod/p1p2DistSq;
  double rSquare=r*r;
  intersects = (distCenterToLineSquare <= rSquare); // r is radius
  // for practical purposes, if the relative error of
  // (r-dist) is 1e-6 of r, we might consider the line as tangent.
  is_tangent = Math.abs(distCenterToLineSquare - rSquare)/rSquare < 1e-12;
} // cowardly refusing to deal with ill-configured lines