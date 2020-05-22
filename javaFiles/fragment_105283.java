AnimatorSet as = new AnimatorSet ();
float y = view.getTranslationY (), distance = 20F;
as.playSequentially (
  ObjectAnimator.ofFloat (view, "translationY", y-distance), // animation 1
  ObjectAnimator.ofFloat (view, "translationY", y), // animation 2
  ObjectAnimator.ofFloat (view, "translationY", y - (distance / 2)), // animation 3
  ObjectAnimator.ofFloat (view, "translationY", y)); // animation 4
as.setDuration (600);
as.start ();