private MediaPlayer do2n;

@Override
public boolean onTouch(View v, MotionEvent event) {
    if (event.getAction() == MotionEvent.ACTION_DOWN) {
        if (v.getId() == R.id.dor) {
            do2n = MediaPlayer.create(this, R.raw.do_leg);
            do2n.start();
        }
    } else if (event.getAction() == MotionEvent.ACTION_UP) {
        if (v.getId() == R.id.dor) {
            if (do2n != null) {
                do2n.stop();
                do2n.release();
                do2n = null;
            }
        }
    }
    return true;
}

@Override
protected void onDestroy() {
    super.onDestroy();
    /**
     * The activity may be destroyed if you receive a long phone call while
     * keeping the button pressed so it's safe to do this
     */
    if (do2n != null) {
        do2n.stop();
        do2n.release();
    }
}