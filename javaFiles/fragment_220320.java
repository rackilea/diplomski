ObjectAnimator scaleXBack = ObjectAnimator.ofFloat(fab, View.SCALE_X, to, from);
ObjectAnimator scaleYBack = ObjectAnimator.ofFloat(fab, View.SCALE_Y, to, from);
ObjectAnimator translationZBack = ObjectAnimator.ofFloat(fab, View.TRANSLATION_Z, to, from);

AnimatorSet set2 = new AnimatorSet();
set2.playTogether(scaleXBack, scaleYBack, translationZBack);
set2.setDuration(300);
set2.setInterpolator(pathInterpolator);