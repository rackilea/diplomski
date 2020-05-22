float radiusSquared;
 float startVectorX;
 float startVectorY;
 float endVectorX;
 float endVectorY;
 float centerX;
 float centerY;
 void convertSector(float radius, float startAngle, float endAngle)
 {
     radiusSquared = radius * radius;
     startVectorX = cos(startAngle);
     startVectorY = sin(startAngle);
     endVectorX = cos(endAngle);
     endVectorY = sin(endAngle);
 }

 boolean testPoint(float x, float y)
 {
     // check if point is within the radius:
     float distanceX = x - centerX;
     float distanceY = y - centerY;
     if((distanceX * distanceX) + (distanceY * distanceY)) > radiusSq)
         return false;

     // check if point is outside start radius vector using 2D dot-product with normal:
     if(((distanceX * -startVectorY) + (distanceY * startVectorX)) < 0.0f)
         return false;

     // check if point is outside end radius vector using 2D dot-product with normal:
     if(((distanceX * -endVectorY) + (distanceY * endVectorX)) > 0.0f)
         return false;

     return true;
 }