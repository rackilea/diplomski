Try this -
 I used it with seekbar. You can use it for your view. As per your case. You should Progressbar or Seekbar.

seekbar = ((CustomSeekbar) findViewById(R.id.customSeekBar));

       seekbar.setMax(2600);

final ObjectAnimator animation = ObjectAnimator.ofInt(seekbar, "progress", 0, 800;
      animation.setDuration(1500);
      animation.setInterpolator(new DecelerateInterpolator());
      animation.start();
      seekbar.clearAnimation();

Here 0 is the starting value and 800 is the max value. Please change is as per your requirement.