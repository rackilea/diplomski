import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class ExpandView extends SurfaceView implements SurfaceHolder.Callback {

    private DrawThread drawThread;

    public ExpandView(Context context) {
        super(context);
    }

    public ExpandView(Context context, AttributeSet attrs) {
        super(context, attrs);
        getHolder().addCallback(this);
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {

        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.YOUR_DRAWABLE_ID);

        drawThread = new DrawThread(holder, bitmap);
        drawThread.setRunning(true);
        drawThread.start();
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {

        boolean retry = true;

        drawThread.setRunning(false);

        while (retry) {
            try {
                drawThread.join();
                retry = false;
            } catch (InterruptedException e) {

            }
        }
    }

    private class DrawThread extends Thread {
        private static final int FRAME_RATE = 30;
        private static final float ANIMATION_SPEED_MILLIS = 10_000;

        private Bitmap newBitmap;
        private int canvasWidth;
        private int canvasHeight;
        private int bitmapWidth;
        private int bitmapHeight;

        private boolean isRunning;
        private final SurfaceHolder surfaceHolder;
        private Bitmap bitmap;
        private long startTime;
        private long lastDrawTime;
        private Paint paint;

        //crop rate should be >=0 and <= 1
        private float startCropRate = 0.2f;
        private float targetCropRate = 1;
        private float currentCropRate;

        private boolean expand;

       private int verticalOffset;
       private int horizontalOffset;
       private int newWidth;
       private int newHeight;
       private int newX;
       private int newY;

        public DrawThread(SurfaceHolder surfaceHolder, Bitmap bitmap) {
            this.surfaceHolder = surfaceHolder;

            canvasWidth = surfaceHolder.getSurfaceFrame().width();
            canvasHeight = surfaceHolder.getSurfaceFrame().height();

            this.bitmap = resizeBitmap(bitmap, canvasHeight, canvasWidth);

            bitmapWidth =  this.bitmap.getWidth();
            bitmapHeight =  this.bitmap.getHeight();

            paint = new Paint(Paint.DITHER_FLAG);

            expand = startCropRate > targetCropRate;
        }

        private Bitmap resizeBitmap(Bitmap bm, int canvasHeight, int canvasWidth) {
            int width = bm.getWidth();
            int height = bm.getHeight();

            float scale = Math.min(canvasWidth/(float)width, canvasHeight/(float)height);

            Matrix matrix = new Matrix();
            matrix.setScale(scale, scale);

            Bitmap resizedBitmap = Bitmap.createBitmap(
                    bm, 0, 0,width,height, matrix, false);
            bm.recycle();

            return resizedBitmap;
        }

        @Override
        public void run() {

            Canvas canvas;
            long currentTime;
            long animationTime;
            float newScale;

            startTime = System.currentTimeMillis();

            while (isRunning) {

                if (currentCropRate == targetCropRate) {
                    isRunning = false;
                    return;
                }

                currentTime = System.currentTimeMillis();

                if (currentTime - lastDrawTime < 1000 / FRAME_RATE) {
                    continue;
                }

                animationTime = currentTime - startTime;


                newScale = startCropRate + (targetCropRate - startCropRate) * (animationTime / ANIMATION_SPEED_MILLIS);

                currentCropRate = expand ? Math.max(targetCropRate, newScale) : Math.min(newScale, targetCropRate);

                lastDrawTime = currentTime;

                canvas = null;

                try {

                    canvas = surfaceHolder.lockCanvas(null);

                    synchronized (surfaceHolder) {

                        canvas.drawColor(Color.BLACK, PorterDuff.Mode.CLEAR);

                        drawImage(canvas);
                    }

                } catch (Exception e) {
                e.printStackTrace();
                } finally {
                    if (canvas != null) {
                        surfaceHolder.unlockCanvasAndPost(canvas);
                    }
                }
            }

        }

        private void drawImage(Canvas canvas) {

            newWidth = (int) (bitmapWidth * currentCropRate);
            newHeight = (int) (bitmapHeight * currentCropRate);

            newX = (bitmapWidth - newWidth) / 2;
            newY = (bitmapHeight - newHeight) / 2;

            newBitmap = Bitmap.createBitmap(bitmap, newX, newY,newWidth,newHeight);

            verticalOffset = (canvasHeight - newBitmap.getHeight()) / 2;
            horizontalOffset =  (canvasWidth - newBitmap.getWidth()) / 2;

            canvas.drawBitmap(newBitmap, horizontalOffset, verticalOffset, paint);
        }


        private void setRunning(boolean running) {
            this.isRunning = running;
        }
    }
}