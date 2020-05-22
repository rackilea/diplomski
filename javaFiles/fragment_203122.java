yourFirstAnim.setAnimationListener(new AnimationListener() {

    @Override
    public void onAnimationStart(Animation animation) {
    }

    @Override
    public void onAnimationRepeat(Animation animation) {
    }

    @Override
    public void onAnimationEnd(Animation animation) {
      doYourNextAnim()
    }
  });