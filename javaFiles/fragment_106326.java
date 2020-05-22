public class drawingView extends View implements OnTouchListener{

static int x,y,r=255,g=255,b=255;
final static int radius=30;
Paint paint;   

public drawingView(Context context)
{
    super(context);
        paint=new Paint();
    paint.setAntiAlias(true);      
    paint.setARGB(255, r, g, b);    

    setFocusable(true);

    this.setOnTouchListener(this);
}

public void onDraw(Canvas canvas)
{
    paint.setARGB(255, r, g, b);

    //drawing the circle
    canvas.drawCircle(x,y,radius,paint);

}

public boolean onTouch(View view,MotionEvent event)
{
    x=(int)event.getX()-(radius/2);      //logic to plot the circle in exact touch place
    y=(int)event.getY()-(radius/2);
      //System.out.println("X,Y:"+"x"+","+y);      
    randColor();  
    invalidate(); 


    if (event.getAction() == MotionEvent.ACTION_UP) {
        paint.setARGB(12, r, g, b);
    }
    return true;

}



public void randColor()
{
    //r=(int)(Math.random()*255);
    //g=(int)(Math.random()*255);
    //b=(int)(Math.random()*255);
    r=1;
    g=2;
    b=3;
    //Toast.makeText(c, "r,g,b="+r+","+g+","+b,Toast.LENGTH_SHORT).show();
}

public void dissColor(){

    r=255;
    g=255;
    b=255;

}
}