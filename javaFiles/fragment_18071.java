// Solve for time
float time = (float)(intersectionDistance / lineLength);

// If time is outside the boundaries, return null. This algorithm can 
// return a negative time which indicates the previous intersection. 
if (time > 1.0f || time < 0.0f) {
   return null;
}

// Solve the intersection and normal
float ix = time * dx + start.x;
float iy = time * dy + start.y;
float nx = (float)((ix - cornerX) * inverseRadius);
float ny = (float)((iy - cornerY) * inverseRadius);

return new Intersection( ix, iy, time, nx, ny );