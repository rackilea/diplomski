float y = // Yaw angle
float p = // Pitch angle
float k = // Move distance

float xzLength = cos(p) * k;
float dx = xzLength * cos(y);
float dz = xzLength * sin(y);
float dy = k * sin(p);

// Update your camera:
camera.x += dx;
camera.y += dy;
camera.z += dz;