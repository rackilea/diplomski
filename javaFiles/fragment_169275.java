int[] depth = kinect.getRawDepth();

if (depth == null) {
  // do something here where you handle there being no image
} else {
  // We're just going to calculate and draw every 4th pixel (equivalent of 160x120)
  int skip = 4;

  // Translate and rotate
  translate(width/2,height/2,-50);
  rotateY(a);

  for(int x=0; x<w; x+=skip) {
    for(int y=0; y<h; y+=skip) {
      int offset = x+y*w;
      // Convert kinect data to world xyz coordinate
      int rawDepth = depth[offset];
      PVector v = depthToWorld(x,y,rawDepth);

      stroke(255);
      pushMatrix();
      // Scale up by 200
      float factor = 200;
      translate(v.x*factor,v.y*factor,factor-v.z*factor);
      // Draw a point
      point(0,0);
      popMatrix();
    }
  }

  // Rotate
  a += 0.015f;
}