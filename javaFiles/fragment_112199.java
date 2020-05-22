// Refer the ImageView like this
imageView = (ImageView) findViewById(R.id.img);

// Load the animation like this
animSlide = AnimationUtils.loadAnimation(getApplicationContext(),
                    R.anim.slide);

// Start the animation like this
imageView.startAnimation(animSlide);