import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.View;

public class LongShadowTextView extends View {
    private Bitmap mBitmap;
    private String mText;

    public LongShadowTextView(Context context) {
        super(context);
    }

    public void setText(String text) {
        Paint paint = new Paint();
        // TODO provide setters for these values
        paint.setColor(Color.BLACK);
        paint.setTextSize(142);

        Rect rect = new Rect();
        paint.getTextBounds(text, 0, text.length(), rect);

        Bitmap bitmap = Bitmap.createBitmap(rect.width() + rect.height(), rect.height(), Bitmap.Config.ALPHA_8);
        Canvas canvas = new Canvas(bitmap);

        canvas.drawText(text, 0, rect.height(), paint);

        Rect src = new Rect();
        RectF dst = new RectF();

        int w = bitmap.getWidth();
        int h = bitmap.getHeight();

        src.left = 0;
        src.right = w;

        for (int i = 0; i < h; ++i) {
            src.top = i;
            src.bottom = i + 1;

            dst.left = 1;
            dst.top = i + 1;
            dst.right = 1 + w;
            dst.bottom = i + 2;

            canvas.drawBitmap(bitmap, src, dst, null);
        }

        mText = text;
        mBitmap = bitmap;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawBitmap(mBitmap, 0, 0, null);
    }
}