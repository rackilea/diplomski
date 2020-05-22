ValueAnimator animator = ValueAnimator.ofInt(0, 255, 0);
animator.setDuration(200).setStartDelay(200L);
animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
    @Override
    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        int color = Color.argb((int) valueAnimator.getAnimatedValue(), 255, 0, 0);
        stockExchangeModel.getBackground().setColorFilter(color, PorterDuff.Mode.SRC_ATOP);
       }
    });
animator.start();