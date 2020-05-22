Animation a = AnimationUtils.loadAnimation(this, R.anim.alpha);
a.reset();
a.setRepeatMode(Animation.REVERSE);
a.setRepeatCount(5); // will be infinite if -1
Button btn = (Button ) findViewById(R.id.btn);
btn.clearAnimation();
btn.startAnimation(a);