View.OnTouchListener onTouchListener = new View.OnTouchListener() {
@Override
 public boolean onTouch(View view, MotionEvent motionEvent) {
    if (event.getPointerCount() == 2) {
        int action = event.getAction();
        int pureaction = action & MotionEvent.ACTION_MASK;
        if (pureaction == MotionEvent.ACTION_POINTER_DOWN) {
            mBaseDist = getDistance(event);
            mBaseRatio = mRatio;
        } else {
            float delta = (getDistance(event) - mBaseDist) / STEP;
            float multi = (float)Math.pow(2, delta);
            mRatio = Math.min(1024.0f, Math.max(0.1f, mBaseRatio * multi));
           ((TextView)view).setTextSize(mRatio+13);
            //Definir aquí el tamaño del texto
            //textView1.setTextSize(mRatio+13);
            //textView2.setTextSize(mRatio+13);
        }
    }
    return true;
});
textView1.setOnTouchListener(onTouchListener );
textView2.setOnTouchListener(onTouchListener );