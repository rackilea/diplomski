anim4.addListener(new AnimatorListenerAdapter(){
    @Override
    public void onAnimationEnd(Animator animation) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                anim4.start();
            }
        }, 3000);
    }
});