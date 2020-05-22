// Generate new random coordinates
  circleX = random(360);
  circleY = random(360);
  // Draw circle at those coordinates
  ellipse(circleX, circleY, 10, 10);

  // Check whether the coordinates are withing the big circle
  r = (circleX-180)*(circleX-180) + (180-circleY)*(180-circleY);