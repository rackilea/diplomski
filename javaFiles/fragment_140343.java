AffineTransform af = new AffineTransform();
  af.rotate(Math.PI/4, ax, ay);//rotate 45 degrees around ax, ay

  AffineTransform bf = new AffineTransform();
  bf.rotate(Math.PI/4, bx, by);//rotate 45 degrees around bx, by

  ra = a.createTransformedArea(af);//ra is the rotated a, a is unchanged
  rb = b.createTransformedArea(bf);//rb is the rotated b, b is unchanged

  if(ra.intersects(rb)){
    //true if intersected after rotation
  }