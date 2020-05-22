import android.app.Service;
import android.content.Intent;
import android.graphics.PixelFormat;
import android.os.IBinder;
import android.view.GestureDetector;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;

public class Bubble extends Service{
    private WindowManager windowManager;
    private ImageView chatHead;
    private GestureDetector gestureDetector;

    @Override
    public IBinder onBind(Intent intent){
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void onCreate(){
        super.onCreate();

        windowManager = (WindowManager) getSystemService(WINDOW_SERVICE);
        chatHead = new ImageView(this);
        chatHead.setImageResource(R.drawable.floating);
        gestureDetector = new GestureDetector(this, new SingleTapConfirm());

        final WindowManager.LayoutParams params = new     WindowManager.LayoutParams(
                WindowManager.LayoutParams.WRAP_CONTENT,
                WindowManager.LayoutParams.WRAP_CONTENT,
                WindowManager.LayoutParams.TYPE_PHONE,
                WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE,
                PixelFormat.TRANSPARENT);

        params.gravity = Gravity.DISPLAY_CLIP_HORIZONTAL | Gravity.DISPLAY_CLIP_VERTICAL| Gravity.START;
        params.x = 0;
        params.y = 100;
        params.alpha = 0.5f;
        windowManager.addView(chatHead, params);

        try{
            chatHead.setOnTouchListener(new View.OnTouchListener(){
                private WindowManager.LayoutParams paramsF = params;
                private int initialX;
                private int initialY;
                private float initialTouchX;
                private float initialTouchY;

                @Override
                public boolean onTouch(View v, MotionEvent event){
                    if (gestureDetector.onTouchEvent(event)) {
                        Intent dialogIntent = new Intent(Bubble.this, MainActivity.class);
                        dialogIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        startActivity(dialogIntent);
                        return true;
                    } else {
                        switch (event.getAction()){
                            case MotionEvent.ACTION_DOWN:
                                initialX = paramsF.x;
                                initialY = paramsF.y;
                                initialTouchX = event.getRawX();
                                initialTouchY = event.getRawY();
                                break;
                            case MotionEvent.ACTION_UP:
                                return false;
                            case MotionEvent.ACTION_MOVE:
                                paramsF.x = initialX + (int) (event.getRawX() - initialTouchX);
                                paramsF.y = initialY + (int) (event.getRawY() - initialTouchY);
                                windowManager.updateViewLayout(chatHead , paramsF);
                                break;
                        }
                    }

                    return false;
                }
            });
        }catch(Exception ignored){}
    }

    private class SingleTapConfirm extends GestureDetector.SimpleOnGestureListener {

        @Override
        public boolean onSingleTapUp(MotionEvent event) {
            return true;
        }
    }