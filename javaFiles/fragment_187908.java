Runnable goToImage2;
Runnable goToImage1 = new Runnable() {
  @Override
  public void run() {
   Picasso.with(TokenActivity.this).load(R.drawable.app_icon).into(iconImageView);
  handler.postDelayed(goToImage2, 2000);
  }
}
goToImage2 = new Runnable() {
  @Override
  public void run() {
   Picasso.with(TokenActivity.this).load(R.drawable.camera_icon).into(iconImageView);
  handler.postDelayed(goToImage1, 2000);
  }
}