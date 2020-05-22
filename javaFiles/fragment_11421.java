//Used for storing rectangles        
public static List<Rect> rectangles;
public class DrawRectangle extends View {

    public DrawRectangle(Context context){

    super(context);

}

@Override
protected void onDraw(Canvas canvas) {
    super.onDraw(canvas);

    //Draw previous rectangles
    for(int i=0;i<rectangles.size();i++){
        canvas.drawRect(rectangles.get(i), paintColor );
    }
    Rect ourRect = new Rect();

    ourRect.set(0, 0, canvas.getWidth()/2, canvas.getHeight()/2);

    Paint paintColor = new Paint();

    if(MainActivity.isBlue){
        paintColor.setColor(Color.BLUE);
    }

    paintColor.setStyle(Paint.Style.FILL);

    //Draw to actual canvas
    canvas.drawRect(ourRect, paintColor );
    rectangles.add(ourRect)