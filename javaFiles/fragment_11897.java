ImageView imageView = (ImageView) findViewById(R.id.your_image);

float bottomOfScreen = getResources().getDisplayMetrics()
    .heightPixels - (imageView.getHeight() * 4);
        //bottomOfScreen is where you want to animate to

imageView.animate()
    .translationY(bottomOfScreen)
    .setInterpolator(new AccelerateInterpolator())
    .setInterpolator(new BounceInterpolator())
    .setDuration(2000);