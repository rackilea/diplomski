Animation animFadeOut = AnimationUtils.loadAnimation(this, R.anim.fade_out);

Animation animFadeIn = AnimationUtils.loadAnimation(this, R.anim.fade_in);

    animFadeOut.reset();
    imageview.clearAnimation();
    imageview.startAnimation(animFadeOut);


    animFadeIn.reset();
    imageview.clearAnimation();
    imageview.startAnimation(animFadeIn);