@Override
public boolean onTouch(View v, MotionEvent event) {
    switch (event.getAction()) {
        case MotionEvent.ACTION_DOWN:
            mp.setLooping(true);
            mp.start();
            return true;
        case MotionEvent.ACTION_UP:
            mp.pause();
            return true;
    }
    return false;
}