private void startScaleAnimation(View view) {
        ObjectAnimator scaleDownX = ObjectAnimator.ofFloat(view, "scaleX", 0.8f);
        ObjectAnimator scaleDownY = ObjectAnimator.ofFloat(view, "scaleY", 0.8f);
        scaleDownX.setDuration(150);
        scaleDownY.setDuration(150);

        scaleDownX.start();
        scaleDownY.start();
    }

    private void cancelScaleAnimation(View view) {
        ObjectAnimator scaleDownX = ObjectAnimator.ofFloat(view, "scaleX", 1.0f);
        ObjectAnimator scaleDownY = ObjectAnimator.ofFloat(view, "scaleY", 1.0f);
        scaleDownX.setDuration(150);
        scaleDownY.setDuration(150);

        scaleDownX.start();
        scaleDownY.start();
    }