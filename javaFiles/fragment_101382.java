//Rotate Asteroids
ImageView mAsteroids = (ImageView) findViewById(R.Id.Asteroids);
mAsteroids.setDrawingCacheEnabled(true);
rAnim = new RotateAnimation(0.0F, 359.0F, Dimension.RelativeToSelf, 0.5F, Dimension.RelativeToSelf, 0.5F);  
rAnim.Interpolator = new LinearInterpolator();
rAnim.RepeatCount = Animation.Infinite;
rAnim.Duration = 1500; //<-- you duration
mAsteroids.StartAnimation(rAnim);