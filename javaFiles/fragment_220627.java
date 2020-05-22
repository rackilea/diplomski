import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.view.View;

public class MarkerView extends View {

    private final Paint markerPaint;
    private RectF oval;
    private final int boundingRectDimens = 200;
    private int centerX;
    private int centerY;

    private final float startAngle = 190;
    private final float sweepAngle = 90;
    private final float markerAngle = 180; // angle of markers w.r.t start point and end/sweep point


    public MarkerView(Context context) {
        super(context);
        markerPaint = createMarkerPaint();

    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        centerX = w / 2;
        centerY = h / 2;
        oval = new RectF(centerX - boundingRectDimens,
                centerY - boundingRectDimens,
                centerX + boundingRectDimens,
                centerY + boundingRectDimens);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(Color.DKGRAY);
        canvas.drawArc(oval, startAngle, sweepAngle, false, markerPaint);


        float startX, startY, endX, endY;
        // calculate start points.

        //get a line from startAngle till markerAngle.
        startX = (float) (Math.cos(Math.toRadians(startAngle)) * boundingRectDimens + centerX);
        startY = (float) (Math.sin(Math.toRadians(startAngle)) * boundingRectDimens + centerY);
        endX = (float) (Math.cos(Math.toRadians(startAngle + markerAngle)) * boundingRectDimens + centerX);
        endY = (float) (Math.sin(Math.toRadians(startAngle + markerAngle)) * boundingRectDimens + centerY);

        // we need to draw only a part of the entire line, using vector for this.
        // vector dimens.
        float desiredLen = 0.05f;  // maker height can be adjusted by changing this value.
        float upLen = 1 - desiredLen;
        float downLen = 1 + desiredLen;
        // calculate down vector.
        float desiredX = downLen * (startX - endX) + endX;
        float desiredY = downLen * (startY - endY) + endY;

        markerPaint.setColor(Color.YELLOW);
        canvas.drawLine(startX, startY, desiredX, desiredY, markerPaint);
        // get up vector
        desiredX = upLen * (startX - endX) + endX;
        desiredY = upLen * (startY - endY) + endY;
        canvas.drawLine(startX, startY, desiredX, desiredY, markerPaint);


        // repeat same for end/sweep point.
        startX = (float) (Math.cos(Math.toRadians(startAngle + sweepAngle)) * boundingRectDimens + centerX);
        startY = (float) (Math.sin(Math.toRadians(startAngle + sweepAngle)) * boundingRectDimens + centerY);
        endX = (float) (Math.cos(Math.toRadians(startAngle + sweepAngle + markerAngle)) * boundingRectDimens + centerX);
        endY = (float) (Math.sin(Math.toRadians(startAngle + sweepAngle + markerAngle)) * boundingRectDimens + centerY);

        // calculate down vector.
        desiredX = downLen * (startX - endX) + endX;
        desiredY = downLen * (startY - endY) + endY;

        markerPaint.setColor(Color.BLUE);
        canvas.drawLine(startX, startY, desiredX, desiredY, markerPaint);
        // get up vector
        desiredX = upLen * (startX - endX) + endX;
        desiredY = upLen * (startY - endY) + endY;
        canvas.drawLine(startX, startY, desiredX, desiredY, markerPaint);


    }


    private Paint createMarkerPaint() {
        Paint p = new Paint();
        p.setAntiAlias(true);
        p.setDither(true);
        p.setColor(Color.RED);
        p.setStyle(Paint.Style.STROKE);
        p.setStrokeWidth(20);
        p.setStrokeCap(Paint.Cap.ROUND); // makes the stroke projects out as semicircle
        p.setStrokeJoin(Paint.Join.ROUND); // makes outer edges of a join meet in circular arc
        return p;
    }
}