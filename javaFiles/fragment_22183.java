public class Circle extends View {
    Paint paint = new Paint();
    Path path = new Path();
    private static final String s = "Hello world example";

    public Circle(Context context) {
      super(context);
      paint.setColor(Color.BLACK);
      paint.setStyle(Style.STROKE);
      paint.setStrokeWidth(2);
      paint.setAntiAlias(true);
      paint.setTextSize(30);
    }

    public void onDraw(Canvas c) {   
      c.rotate(-90, getWidth()/2, getHeight()/2);
      path.addCircle(getWidth()/2, getHeight()/2, 180, Direction.CW);
      c.drawTextOnPath(s, path, 0, 10, paint);
      setLayerType(View.LAYER_TYPE_SOFTWARE, null);
    } 
}