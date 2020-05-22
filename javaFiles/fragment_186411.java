@Override
    public void onClick(View view) {

        final int from = mItemInputEditText.getWidth();
        final int to = (int) (from * 0.8f);
        final LinearInterpolator interpolator = new LinearInterpolator();

        ValueAnimator firstAnimator = ValueAnimator.ofInt(from, to);
        firstAnimator.setTarget(mItemInputEditText);
        firstAnimator.setInterpolator(interpolator);
        firstAnimator.setDuration(DURATION);

        final ViewGroup.LayoutParams params = mItemInputEditText.getLayoutParams();
        firstAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                params.width = (Integer) animation.getAnimatedValue();
                mItemInputEditText.requestLayout();
            }
        });

        firstAnimator.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                mItemInputEditText.setVisibility(View.GONE);
                addButton.setVisibility(View.VISIBLE);

                ValueAnimator secondAnimator = ValueAnimator.ofInt(to, buttonWidth);
                secondAnimator.setTarget(addButton);
                secondAnimator.setInterpolator(interpolator);
                secondAnimator.setDuration(DURATION);

                final ViewGroup.LayoutParams params = addButton.getLayoutParams();
                secondAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    @Override
                    public void onAnimationUpdate(ValueAnimator animation) {
                        params.width = (Integer) animation.getAnimatedValue();
                        addButton.setAlpha(animation.getAnimatedFraction());
                        addButton.requestLayout();
                    }
                });

                secondAnimator.addListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationStart(Animator animation) {
                        addButton.setAlpha(0.0f);
                    }
                });

                secondAnimator.start();
            }
        });

        firstAnimator.start();
    }