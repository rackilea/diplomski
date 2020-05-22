import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.ArcShape;
import android.graphics.drawable.shapes.OvalShape;
import android.util.AttributeSet;
import android.view.View;

public class Button1 extends View
{
    private int radius = 100;

     /**
     * @param context
     * @param attrs
     */
    public Button1(Context context, AttributeSet attrs) 
    {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas)
    {
        super.onDraw(canvas);

        // SETUP
        int r = (int) radius ;

        // BG WHITE
        int cx = this.getWidth() / 2, cy = this.getHeight() / 2;
        Paint bg_paint = new Paint();
        bg_paint.setAntiAlias(true);
        bg_paint.setARGB(255, 255, 255, 255);
        ShapeDrawable bg = new ShapeDrawable(new OvalShape()); // If removed, then ArcShape causes the same CNFE error
        canvas.drawCircle(cx, cy, r, bg_paint);

        // ROTATING ARC
        ShapeDrawable drawable = new ShapeDrawable(new ArcShape(-90, 60));
        drawable.getPaint().setColor(0xff74AC23);
        drawable.setBounds(cx - (r-2), cy - (r-2), cx + (r-2), cy + (r-2));
        drawable.draw(canvas);

        invalidate();
    }
}