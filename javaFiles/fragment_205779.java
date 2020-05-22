dragHandle.setOnTouchListener(new View.OnTouchListener() {

    float centerX, centerY, startR, startScale, startX, startY;

    public boolean onTouch(View v, MotionEvent e) {

        if (e.getAction() == MotionEvent.ACTION_DOWN) {

            // calculate center of image
            centerX = (imageView.getLeft() + imageView.getRight()) / 2f;
            centerY = (imageView.getTop() + imageView.getBottom()) / 2f;

            // recalculate coordinates of starting point
            startX = e.getRawX() - dragHandle.getX() + centerX;
            startY = e.getRawY() - dragHandle.getY() + centerY; 

            // get starting distance and scale
            startR = (float) Math.hypot(e.getRawX() - startX, e.getRawY() - startY);
            startScale = imageView.getScaleX();

        } else if (e.getAction() == MotionEvent.ACTION_MOVE) {

            // calculate new distance
            float newR = (float) Math.hypot(e.getRawX() - startX, e.getRawY() - startY);

            // set new scale
            float newScale = newR / startR * startScale;
            imageView.setScaleX(newScale);
            imageView.setScaleY(newScale);

            // move handler image
            dragHandle.setX(centerX + imageView.getWidth()/2f * newScale);
            dragHandle.setY(centerY + imageView.getHeight()/2f * newScale);

        } else if (e.getAction() == MotionEvent.ACTION_UP) {

        }
        return true;
    }
});