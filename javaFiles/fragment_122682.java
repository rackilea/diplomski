public void resize(ImageView resizeButton) {
    resizeButton.setOnTouchListener(new View.OnTouchListener() {

        float startAngle;
        float zeroAngle;
        int firstPointX;
        int firstPointY; 

        public boolean onTouch(View v, MotionEvent motionEvent) {

            if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                int[] locationOfLayout = new int[2];
                int[] locationOfDrag = new int[2];

                layout.getLocationOnScreen(locationOfLayout);
                dragHandle.getLocationOnScreen(locationOfDrag);

                firstPointX = locationOfLayout[0];
                firstPointY = locationOfLayout[1];

                int secondPointX = motionEvent.getRawX();
                int secondPointY = motionEvent.getRawY();

                zeroAngle = findRotation(firstPointX, firstPointY, secondPointX, secondPointY) // remember "zero" angle
                startAngle = layout.getRotation(); // remember angle at which layout is rotated at the start


            } else if (motionEvent.getAction() == MotionEvent.ACTION_MOVE) {

                layout.setRotation(findRotation(firstPointX, firstPointY, motionEvent.getRawX(), motionEvent.getRawY()) - zeroAngle + startAngle); // rotate relative to start and zero angle


            } else if (motionEvent.getAction() == MotionEvent.ACTION_UP) {

            }
            return true;
        }
    });
}

private float findRotation(int firstPointX, int firstPointY, int secondPointX, int secondPointY) {
    double delta_x = (secondPointX - firstPointX);
    double delta_y = (secondPointY - firstPointY);
    double radians = Math.atan2(delta_y, delta_x);
    return (float) Math.toDegrees(radians);
}