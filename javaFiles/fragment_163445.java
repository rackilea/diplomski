public class DoodleImageView extends View {

    // drawing path
    private Path drawPath;
    // drawing point
    private boolean drawPoint;
    // drawing and canvas paint
    public Paint drawPaint;
    public Paint tempPaint;
    private Paint canvasPaint;
    // initial color
    private int paintColor;
    // canvas
    private Canvas drawCanvas;
    // canvas bitmap
    private Bitmap canvasBitmap;

    private ArrayList<Path> paths = new ArrayList<Path>();
    private ArrayList<Integer> pathscolor = new ArrayList<Integer>();
    private ArrayList<Integer> pointcolor = new ArrayList<Integer>();
    private ArrayList<Integer> marker = new ArrayList<Integer>();
    private ArrayList<Point> points = new ArrayList<Point>();

    private float mX, mY;
    private final float TOUCH_TOLERANCE = 1;

    public DoodleImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setupDrawing();
        // TODO Auto-generated constructor stub
    }

    private void setupDrawing() {
        // get drawing area setup for interaction

        drawPath = new Path();
        drawPaint = new Paint();
        // drawPaint.setColor(paintColor);
        drawPaint.setAntiAlias(true);
        drawPaint.setStrokeWidth(20);
        drawPaint.setStyle(Paint.Style.STROKE);
        drawPaint.setStrokeJoin(Paint.Join.ROUND);
        drawPaint.setStrokeCap(Paint.Cap.ROUND);
        canvasPaint = new Paint(Paint.DITHER_FLAG);
    }

    private Paint setUpPaint(int color) {
        tempPaint = new Paint();
        tempPaint.setColor(color);
        tempPaint.setAntiAlias(true);
        tempPaint.setStrokeWidth(20);
        tempPaint.setStyle(Paint.Style.STROKE);
        tempPaint.setStrokeJoin(Paint.Join.ROUND);
        tempPaint.setStrokeCap(Paint.Cap.ROUND);
        return tempPaint;
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        // TODO Auto-generated method stub
        super.onSizeChanged(w, h, oldw, oldh);
        canvasBitmap = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888);
        drawCanvas = new Canvas(canvasBitmap);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        // TODO Auto-generated method stub
        if (marker.size() > 0) {

            for (int i = 0; i < paths.size(); i++) {

                canvas.drawPath(paths.get(i), setUpPaint(pathscolor.get(i)));
            }

            for (int i = 0; i < points.size(); i++) {
                canvas.drawPoint(points.get(i).x, points.get(i).y,
                        setUpPaint(pointcolor.get(i)));
            }
        }
     canvas.drawPath(drawPath,drawPaint);

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        // TODO Auto-generated method stub

        float touchX = event.getX();
        float touchY = event.getY();
        switch (event.getAction()) {
        case MotionEvent.ACTION_DOWN:

            touch_start(touchX, touchY);
            invalidate();
            break;
        case MotionEvent.ACTION_MOVE:

            touch_move(touchX, touchY);
            invalidate();
            break;
        case MotionEvent.ACTION_UP:

            touch_up();
            invalidate();
            break;
        default:
            return false;
        }
        invalidate();
        return true;
    }

    private void touch_start(float x, float y) {
        drawPoint = true;
        drawPath.reset();
        drawPath.moveTo(x, y);
        drawCanvas.drawPath(drawPath, drawPaint);
        mX = x;
        mY = y;

    }

    private void touch_move(float x, float y) {
    float dx = Math.abs(x - mX);
    float dy = Math.abs(y - mY);
    if (dx >= TOUCH_TOLERANCE || dy >= TOUCH_TOLERANCE) {
        drawPath.quadTo(mX, mY, (x + mX) / 2, (y + mY) / 2);
        drawPoint = false;
        drawCanvas.drawPath(drawPath,drawPaint);
        mX = x;
        mY = y;
    }
}


    private void touch_up() {
        if (drawPoint == true) {
            drawCanvas.drawPoint(mX, mY, drawPaint);
            Point p = new Point();
            p.set((int) mX, (int) mY);
            points.add(p);
            pointcolor.add(drawPaint.getColor());
            marker.add(0);

        } else {
            drawPath.lineTo(mX, mY);
            drawCanvas.drawPath(drawPath, drawPaint);
            paths.add(drawPath);
            drawPath = new Path();
            drawPath.reset();
            pathscolor.add(drawPaint.getColor());
            marker.add(1);

        }
    }

    public void clear() {
        if (marker.size() > 0) {
            paths.clear();
            points.clear();
            pathscolor.clear();
            pointcolor.clear();
            invalidate();
        }

    }

    public void undo() {
        if (marker.size() > 0) {
            if (marker.get(marker.size() - 1) == 1) {
                if (paths.size() > 0) {
                    paths.remove(paths.size() - 1);
                    pathscolor.remove(pathscolor.size() - 1);
                    marker.remove(marker.size() - 1);
                    invalidate();
                }
            } else {
                if (points.size() > 0) {
                    points.remove(points.size() - 1);
                    pointcolor.remove(pointcolor.size() - 1);
                    marker.remove(marker.size() - 1);
                    invalidate();

                }

            }
        }
    }
}