PVector[] points = new PVector[4];              // Define a PVector array containing the points of the shape
points[0] = new PVector(0, 0);                  // Start at bottom left
points[1] = new PVector(random(512), 0);        // The normal width is 512, the normal height 1024
points[2] = new PVector(random(512), random(1024)); // y coordinates are from bottom to top!
points[3] = new PVector(0, random(1024));

f.addGlyph('A').addContour(points);