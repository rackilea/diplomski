public class GradientView extends View {

     Paint paint;
     LinearGradient gradient;
     int[] colors = [Color.RED, Color.GREEN];

     public GradientView(Context context, int gradientHeight) {
          super(context);
          paint = new Paint();
          setGradientHeight(gradientHeight);
     }

     @Override
     protected void onDraw(Canvas canvas) {
        // TODO Auto-generated method stub
        super.onDraw(canvas);
        paint.setShader(colorGradient);
        canvas.drawPaint(paint);
    }

    public void setGradientHeight(int height){
        colorGradient = new LinearGradient(0, 0, 0, height * 0.01 * super.getHeight(), colors, null, Shader.TileMode.MIRROR);
        paint.setShader(colorGradient);
        invalidate();
    }
 }