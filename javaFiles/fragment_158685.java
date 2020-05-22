ValueAnimator animator = ValueAnimator.ofFloat(0f, 100.2f);
animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator animation) {
                tvTotalAmount.setText(String.valueOf((float)animation.getAnimatedValue()));
            }
        });
animator.setDuration(1500);
animator.start();