private void animation() {
    imageView.setOnTouchListener(new View.OnTouchListener() {
        @Override
        public boolean onTouch(View v, MotionEvent event) {
            imageView.animate().translationY(height/2).setDuration(1000).start();
            imageView.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    ScaleAnimation scaleAnimation = new ScaleAnimation(0, 1, 0, 1,imageView.getWidth()/2,imageView.getY() + imageView.getHeight()/2);
                    scaleAnimation.setDuration(1000);
                    imageView.startAnimation(scaleAnimation);
                    return true;
                }
            });
            return false;
        }
    });
}