AffineTransform scalingByFactor2 = 
    AffineTransform.getScaleInstance(2,2);

AffineTransform rotationBy45degrees = 
    AffineTransform.getRotateInstance(Math.toDegrees(45));

g.transform(rotationBy45degrees);
g.transform(scalingByFactor2);
g.drawRect(0,0,50,100);