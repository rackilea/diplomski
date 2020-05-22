firstImage = (ImageView) findViewById(R.id.imageView1);
final AnimationDrawable frameAnimation = (AnimationDrawable) firstImage.getBackground();
ViewTreeObserver treeObserver = firstImage.getViewTreeObsver();
treeObvserver.addOnGlobalLayoutListener(new OnGlobalLayoutListener(){
   @Override
   public void onGlobalLayout(){
      frameAnimation.start();
   }
}