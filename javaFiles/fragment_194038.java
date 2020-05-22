public class MyLine { //  line

public float x,y;
    public float xStart,yStart,xEnd,yEnd;
    private boolean drawDashed;
    private Paint paint = new Paint();
    public MyLine(boolean drawDashed)
    {
      if(drawDashed){
        ...
        paint.setPathEffect(new DashPathEffect(new float[]{10,20}, 0));
        ....
      } else{  
         ....
         paint.setPathEffect(null);
         ...
      }
    }

public void mouseDown(Path path,float xDown,float yDown){
    //path.moveTo(xDown, yDown);
//  path.lineTo(xDown, yDown);

    xStart = xDown;
    yStart = yDown;
}

public void mouseUp(Path path,float xUp,float yUp){
    //path.lineTo(xUp, yUp);
    xEnd = xUp;
    yEnd = yUp;
}

public void draw(Canvas c){

    c.drawLine(xStart,yStart,xEnd,yEnd,paint);
}

}