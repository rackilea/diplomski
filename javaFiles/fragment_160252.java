edt.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View arg0, boolean hasfocus) {
                if (hasfocus) {
                    Log.e("TAG", "edt focused");
                    //ValueAnimator total
                    ValueAnimator valueAnimator = ValueAnimator.ofFloat(1f, 1.5f);
                    valueAnimator.setDuration(325);
                    valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                        public void onAnimationUpdate(ValueAnimator animation) {
                            float value = (Float) animation.getAnimatedValue();
                            edt.setScaleX(value);
                            edt.setScaleY(value);
                            edt.requestLayout();
                        }
                    });
                    valueAnimator.start();
                } else {
                    Log.e("TAG", "edt not focused");
                    //animation inverse
                }
            }
 });