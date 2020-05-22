public class RectAngle extends View {
    public RectAngle(Context context) {
        super(context);
        setFocusable(true);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        float x = getWidth();
        float y = getHeight();

        Paint topLeftRect = new Paint();
        Paint bottomLeftRect = new Paint();
        Paint topRightRect = new Paint();
        Paint midRightRect = new Paint();
        Paint bottomRightRect = new Paint();

        // Draw  the top left rectangle
        topLeftRect.setStyle(Paint.Style.FILL);
        //topLeftRect.setColor(Color.WHITE);
        topLeftRect.setColor(Color.parseColor("#FFFF99"));
        // canvas.drawPaint(topLeftRect);
        canvas.drawRect(0, 0, x / 2, y / 2, topLeftRect);

        //Draw the bottom left rectangle

        bottomLeftRect.setStyle(Paint.Style.FILL);
        //bottomLeftRect.setColor(Color.WHITE);
        // canvas.drawPaint(bottomLeftRect);
        bottomLeftRect.setColor(Color.parseColor("#FF5599"));
        canvas.drawRect(0, y / 2, x / 2, y, bottomLeftRect);

        //Draw the top tight rectangle

        topRightRect.setStyle(Paint.Style.FILL);
        //topRightRect.setColor(Color.WHITE);
        topRightRect.setColor(Color.parseColor("#FF6600"));
        //canvas.drawPaint(topRightRect);
        canvas.drawRect(x / 2, 0, x, y / 3, topRightRect);

        // Draw the middle right rectangle

        midRightRect.setStyle(Paint.Style.FILL);
        //midRightRect.setColor(Color.WHITE);
        midRightRect.setColor(Color.parseColor("#66FFFF"));
        // canvas.drawPaint(midRightRect);
        canvas.drawRect(x / 2, y/3, x, 2*y / 3, midRightRect);

        //Draw the bottom right rectangle

        bottomRightRect.setStyle(Paint.Style.FILL);
        //bottomRightRect.setColor(Color.WHITE);
        bottomRightRect.setColor(Color.parseColor("#CCCC00"));
        // canvas.drawPaint(bottomRightRect);
        canvas.drawRect(x/2, 2*y/3, x, y, bottomRightRect);




    }
}