//I would do double inline with the initialization, but left here in case you had another reason
double x1,y1, x2,y2, r, midx,midy, newAngle;

x1 = a.center[0];
y1 = a.center[1];
x2 = a.target.center[0];
y1 = a.target.center[1];

r = getDistance(a, a.target)/2;
midx = x1 + (x2 - x1)/2;
midy = y1 + (y2 - y1)/2;

newAngle = Math.toRadians(angle) +
           Math.atan2(midy, midx);

x1 = Math.cos(newAngle) * r + midx;
y1 = Math.sin(newAngle) * r + midy;
x2 = Math.cos(newAngle) * -r + midx;
y2 = Math.sin(newAngle) * -r + midy;
a.move((int)x1,(int)y1);
a.target.move((int)x2,(int)y2);