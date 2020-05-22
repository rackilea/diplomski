imPreview.setImageDrawable(imgColorDotPreviewFlashing);
final Animation animationFlashing = new AlphaAnimation(1f,1f);
animationFlashing.setDuration(250); // duration - quarter a second
animationFlashing.setRepeatCount(Animation.INFINITE); // Repeat animation infinitely
animationFlashing.setRepeatMode(Animation.REVERSE);
animationFlashing.setAnimationListener(new AnimationListener(){
    @Override
    public void onAnimationEnd(Animation animation) {
        if(animation == animationFlashing){
        imPreview.setImageAlpha(255);
        }
    }
    @Override
    public void onAnimationRepeat(Animation animation) {
        if(animation == animationFlashing){
            if(imPreview.getImageAlpha()==0) imPreview.setImageAlpha(255);
            else imPreview.setImageAlpha(0);
        }
    }
    @Override
    public void onAnimationStart(Animation animation) {
        if(animation == animationFlashing){
            imPreview.setImageAlpha(255);
        }
    }
});                          
imPreview.setAnimation(animationFlashing);
startAnimation();