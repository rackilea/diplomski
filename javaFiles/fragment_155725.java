public class DimScreen extends Service {

public static  int ID_NOTIFICATION = 2018;

private WindowManager windowManager;
private LinearLayout saverScreen;
private PopupWindow pwindo;

boolean mHasDoubleClicked = false;
long lastPressTime;
private Boolean _enable = true;


@Override
public IBinder onBind(Intent intent) {
    // TODO Auto-generated method stub
    return null;
}

@Override 
public void onCreate() {
    super.onCreate();
    windowManager = (WindowManager) getSystemService(WINDOW_SERVICE);
    saverScreen = new LinearLayout(this);
    saverScreen.setLayoutParams(new LayoutParams(LayoutParams.FILL_PARENT,LayoutParams.FILL_PARENT));
    Bitmap sample = Bitmap.createBitmap(100, 100, Config.ARGB_8888);
    saverScreen.setBackground(new BitmapDrawable(this.getResources(),
            convertColorIntoBlackAndWhiteImage(sample)));
    saverScreen.setClickable(false);
    saverScreen.setFocusable(false);
    final WindowManager.LayoutParams params = new WindowManager.LayoutParams(
            WindowManager.LayoutParams.FILL_PARENT,
            WindowManager.LayoutParams.FILL_PARENT,
            PixelFormat.TRANSLUCENT);
    params.flags = WindowManager.LayoutParams.FLAG_FULLSCREEN
            |WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE
            |WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE
            |WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL
            |WindowManager.LayoutParams.FLAG_DIM_BEHIND;
    params.dimAmount = (float) 0.6;
    params.screenBrightness = (float) 0.3;
    params.systemUiVisibility = View.SYSTEM_UI_FLAG_LOW_PROFILE;
    windowManager.addView(saverScreen, params);
}
@Override
public void onDestroy() {
    super.onDestroy();
    if (saverScreen != null) windowManager.removeView(saverScreen);
}
private Bitmap convertColorIntoBlackAndWhiteImage(Bitmap orginalBitmap) {
    ColorMatrix colorMatrix = new ColorMatrix();
    colorMatrix.setSaturation(2);
    ColorMatrixColorFilter colorMatrixFilter = new ColorMatrixColorFilter(
            colorMatrix);

    Bitmap blackAndWhiteBitmap = orginalBitmap.copy(
            Bitmap.Config.ARGB_8888, true);

    Paint paint = new Paint();
    paint.setColorFilter(colorMatrixFilter);

    Canvas canvas = new Canvas(blackAndWhiteBitmap);
    canvas.drawBitmap(blackAndWhiteBitmap, 0, 0, paint);

    return blackAndWhiteBitmap;
}