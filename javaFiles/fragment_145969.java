Point2f srcTri = new Point2f(3);
Point2f dstTri = new Point2f(3);

// ...

srcTri.position(0).x((float)landmarks[5*2]).y((float)landmarks[5*2+1]);
srcTri.position(1).x((float)landmarks[6*2]).y((float)landmarks[6*2+1]);
srcTri.position(2).x((float)landmarks[0*2]).y((float)landmarks[0*2+1]);
// and do the same for dstTri

warp_mat = getAffineTransform( srcTri.position(0), dstTri.position(0) );