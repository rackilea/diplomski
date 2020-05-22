view.setOnTouchListener(new View.OnTouchListener() {

    float downX, downY, nowX, nowY, diffX, diffY;

    @Override
    public boolean onTouch(View v, MotionEvent event) {

        switch (event.getAction()) {

            case MotionEvent.ACTION_DOWN:

                downX = event.getRawX();
                downY = event.getRawY();
                break;

            case MotionEvent.ACTION_MOVE:

                nowX = event.getRawX();
                nowY = event.getRawY();

                diffX = nowX - downX;
                diffY = nowY - downY;

                v.setTranslationX(diffX);
                v.setTranslationY(diffY);

                break;

            case MotionEvent.ACTION_UP:

                break;
        }
        return true;
    }
});