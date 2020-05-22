int newX = xVel+this.x;
int newY = yVel+this.y;
if( (newX<0) || (newX>this.maxX) )
    xVel=xVel*-1;
else
    this.x = newX;
if( (newY<0) || (newY>this.maxY) )
    yVel=yVel*-1;
else
    this.y = newY;