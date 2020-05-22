Runnable changeImage = new Runnable() {
  @Override
  public void run() {
   Picasso.with(TokenActivity.this).load(isShowingFirst ? R.drawable.camera_icon : R.drawable.app_icon).into(iconImageView);
  isShowingFirst = !isShowingFirst;
  handler.postDelayed(changeImage, 2000);
  }
}