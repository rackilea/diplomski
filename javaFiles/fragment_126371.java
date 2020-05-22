private float drag;

    ...

    @Override
    protected void onResume() {
        super.onResume();
        mViewPager.postDelayed(new Runnable() {
            @Override
            public void run() {
                mViewPager.beginFakeDrag();
                drag = 0;
                float density = getResources().getDisplayMetrics().density;
                // 120 is the number of dps you want the page to move in total
                ValueAnimator animator = ValueAnimator.ofFloat(0, 120 * density);
                animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    @Override
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        float progress = (float) valueAnimator.getAnimatedValue();
                        mViewPager.fakeDragBy(drag - progress);
                        drag = progress;
                    }
                });
                animator.addListener(new Animator.AnimatorListener() {
                    @Override
                    public void onAnimationStart(Animator animator) { }

                    @Override
                    public void onAnimationEnd(Animator animator) {
                        mViewPager.endFakeDrag();
                    }

                    @Override
                    public void onAnimationCancel(Animator animator) { }

                    @Override
                    public void onAnimationRepeat(Animator animator) { }
                });
                animator.setDuration(400);
                animator.start();
            }
        }, 300);

    }