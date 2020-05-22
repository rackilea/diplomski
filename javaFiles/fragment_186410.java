@Override
    public void onClick(View v) {

        final int from = addButton.getWidth();
        final int to = (int) (from * 1.2f); // increase by 20%
        final LinearInterpolator interpolator = new LinearInterpolator();

        ValueAnimator firstAnimator = ValueAnimator.ofInt(from, to);
        firstAnimator.setTarget(addButton);
        firstAnimator.setInterpolator(interpolator);
        firstAnimator.setDuration(DURATION);

        final ViewGroup.LayoutParams params = addButton.getLayoutParams();
        firstAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                params.width = (Integer) animation.getAnimatedValue();
                addButton.setAlpha(1 - animation.getAnimatedFraction());
                addButton.requestLayout();
            }
        });

        firstAnimator.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                // reset alpha channel
                addButton.setAlpha(1.0f);
                addButton.setVisibility(View.GONE);

                mItemInputEditText.setVisibility(View.VISIBLE);

                ValueAnimator secondAnimator = ValueAnimator.ofInt(to, editTextWidth);
                secondAnimator.setTarget(mItemInputEditText);
                secondAnimator.setInterpolator(interpolator);
                secondAnimator.setDuration(DURATION);

                final ViewGroup.LayoutParams params = mItemInputEditText.getLayoutParams();
                secondAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    @Override
                    public void onAnimationUpdate(ValueAnimator animation) {
                        params.width = (Integer) animation.getAnimatedValue();
                        mItemInputEditText.requestLayout();
                    }
                });

                secondAnimator.start();
            }
        });

        firstAnimator.start();
    }