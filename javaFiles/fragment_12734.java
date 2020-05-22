ArrayList <Animator> animations = new ArrayList<Animator>();
animations.add(ObjectAnimator.ofPropertyValuesHolder(v, pvhX, pvhY));
animations.add(ObjectAnimator.ofPropertyValuesHolder(imageView2, pvhX9, pvhY9));

AnimatorSet animatoreSet = new AnimatorSet();
animatorSet.setDuration(500);
animatorSet.setRepeatCount(0);
animatorSet.playTogether(animations);
animatorSet.start();