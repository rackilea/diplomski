@Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        final int X = (int) motionEvent.getRawX();
        final int Y = (int) motionEvent.getRawY();
        int action = motionEvent.getActionMasked();


        if(action == MotionEvent.ACTION_DOWN) {
            RelativeLayout.LayoutParams lParams = (RelativeLayout.LayoutParams) view.getLayoutParams();
            xDelta = X - lParams.leftMargin;
            yDelta = Y - lParams.topMargin;
            Log.i(TAG, "Action down!");
        }

        if(action == MotionEvent.ACTION_MOVE) {
        Log.i(TAG, "Action move!");

        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) view.getLayoutParams();
            layoutParams.leftMargin = X - xDelta;
            layoutParams.topMargin = Y - yDelta;
            layoutParams.rightMargin = -550;
            layoutParams.bottomMargin = -250;
            view.setLayoutParams(layoutParams);
        }
}