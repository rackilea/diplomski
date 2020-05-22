PVector relativeToWorld(PVector relative) {
  float theta = vel.heading2D() + PI/2;
  float r00 = cos(theta);
  float r01 = -sin(theta);
  float r10 = -r01;
  float r11 = r00;
  PVector world = new PVector();
  world.x = relative.x * r00 + relative.y*r01 + loc.x;
  world.y = relative.x * r10 + relative.y*r11 + loc.y;
  return world;
}

PVector worldToRelative(PVector world) {
  float theta = vel.heading2D() + PI/2;
  float r00 = cos(theta);
  float r01 = sin(theta);
  float r10 = -r01;
  float r11 = r00;
  PVector relative = new PVector();
  relative.x = world.x*r00 + world.y*r10 - loc.x*r00 - loc.y*r10;
  relative.y = world.x*r01 + world.y*r11 - loc.x*r01 - loc.y*r11;
  return relative;
}