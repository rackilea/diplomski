[pseudo code]
firstX,firstY =0  //assumed  x=0; y(0)=0 
loop
for x= 0 to panel width;
{ get interpolatedY(x);
  drawLine from (firstX,firstY) to (nextX,nextY);
  //use Graphics.drawLine command
  firstX=nextX; firstY=nextY;
}