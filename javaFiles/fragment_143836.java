transform = g2d.getTransform();
transform.rotate(Math.toRadians(angleInDegree), pivotX, pivotY);
g2d.setTransform(transform);    
// draw anything and it will be rotated based on rotate method
transform.rotate(Math.toRadians(0), pivotX, pivotY);
g2d.setTransform(transform); // now further drawing will no be drawn rotated