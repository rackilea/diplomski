MediaPlayer sound;
    public boolean onTouchEvent(MotionEvent event) {
            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN:
            if (sound != null) {
                sound.stop();
                sound.release();
                sound = null;
           }
           sound = MediaPlayer.create(getContext(), R.raw.boo);
                    sound.start();
                    pointX.add(event.getX());
                    pointY.add(event.getY());
                    postInvalidate();
                    break;