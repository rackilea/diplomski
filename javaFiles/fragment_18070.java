double inverseRadius = 1.0 / radius;
double lineLength = Math.sqrt( dx * dx + dy * dy );
double cornerdx = cornerX - start.x;
double cornerdy = cornerY - start.y;
double cornerdist = Math.sqrt( cornerdx * cornerdx + cornerdy * cornerdy );
double innerAngle = Math.acos( (cornerdx * dx + cornerdy * dy) / (lineLength * cornerdist) );
double innerAngleSin = Math.sin( innerAngle );
double angle1Sin = innerAngleSin * cornerdist * inverseRadius;

// The angle is too large, there cannot be an intersection
if (Math.abs( angle1Sin ) > 1.0f) {
   return null;
}

double angle1 = Math.PI - Math.asin( angle1Sin );
double angle2 = Math.PI - innerAngle - angle1;
double intersectionDistance = radius * Math.sin( angle2 ) / innerAngleSin;