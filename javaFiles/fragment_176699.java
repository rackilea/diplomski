import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

public class DrawView extends View implements OnTouchListener {

    private static final String TAG = "DrawView";

    private List<List<Point>> _paths = new ArrayList<List<Point>>();
    private List<Point> _lastPath;
    private Paint _paint = new Paint();
    private Path _path = new Path();

    public DrawView(Context context) {
        super(context);

        setFocusable(true);
        setFocusableInTouchMode(true);
        setOnTouchListener(this);

        _paint.setColor(Color.BLACK);
        _paint.setStyle(Paint.Style.STROKE);
        _paint.setStrokeWidth(5);
        _paint.setAntiAlias(true);
    }

    @Override
    protected void onDraw(Canvas canvas) {

        for (List<Point> pointsPath : _paths) {
            _path.reset();
            boolean first = true;

            for (int i = 0; i < pointsPath.size(); i += 2) {
                Point point = pointsPath.get(i);

                if (first) {
                    first = false;
                    _path.moveTo(point.x, point.y);
                } else if (i < pointsPath.size() - 1) {
                    Point next = pointsPath.get(i + 1);
                    _path.quadTo(point.x, point.y, next.x, next.y);
                } else {
                    _path.lineTo(point.x, point.y);
                }
            }
            canvas.drawPath(_path, _paint);
        }
    }

    public boolean onTouch(View view, MotionEvent event) {
        Point point = new Point();
        point.x = event.getX();
        point.y = event.getY();
        Log.d(TAG, "point: " + point);

        switch (event.getAction()) {
        case MotionEvent.ACTION_DOWN:
            _lastPath = new ArrayList<Point>();
            _lastPath.add(point);
            _paths.add(_lastPath);
            break;
        case MotionEvent.ACTION_MOVE:
            _lastPath.add(point);
            break;
        }
        invalidate();
        return true;
    }

    private class Point {
        float x, y;

        @Override
        public String toString() {
            return x + ", " + y;
        }
    }
}