final LinearLayout ChangeThisLayoutAlpha= (LinearLayout) findViewById(R.id.ThisLayout); 
ObjectAnimator animator = ObjectAnimator.ofFloat(ChangeThisLayoutAlpha, "alpha", 1f, 0.5f);
animator.setDuration(2000);
animator.addListener(new AnimatorListenerAdapter() {
    public void onAnimationEnd(Animator animation) {
       ChangeThisLayoutAlpha.setAlpha(1f);
       // Do your transition to the next screen here
    }
})
animator.start();