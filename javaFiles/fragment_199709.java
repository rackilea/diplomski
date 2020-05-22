public class YourActivity extends AppCompatActivity implements MultiplyResponseReceiver {

    @Override
    public void onMultiplyResponseReceived() {

        myCanvas = getHolder().lockCanvas();
        myCanvas.drawColor(Color.TRANSPARENT, PorterDuff.Mode.CLEAR);
        switch (getId()) {
            case R.id.joystickRight:
                // draw_joystick_base(myCanvas, R.drawable.joystick_base);

                float c = bitmapArray[0].getWidth() / 2;
                float d = bitmapArray[0].getHeight() / 2;
                myCanvas.drawBitmap(bitmapArray[0], centerX - c, centerY - d, new Paint());
                break;
            case R.id.joystickLeft:
                // draw_joystick_base(myCanvas, R.drawable.joystick_base);

                float c1 = bitmapArray[0].getWidth() / 2;
                float d1 = bitmapArray[0].getHeight() / 2;
                myCanvas.drawBitmap(bitmapArray[0], centerX - c1, centerY - d1, new Paint());
                break;
        }

        float a = bitmapArray[1].getWidth() / 2;
        float b = bitmapArray[1].getHeight() / 2;
        myCanvas.drawBitmap(bitmapArray[1], hatX_tmp - a, hatY_tmp - b, new Paint());
        getHolder().unlockCanvasAndPost(myCanvas);
        // Do things like update the progress bar
    }
}