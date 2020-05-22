Glide.with(this)
    .load("http://pheds.com.au/example1.png")
    .into(new SimpleTarget<GlideDrawable>(drawableWidth, drawableHeight) {
        @Override
        public void onResourceReady(GlideDrawable resource, GlideAnimation<? super GlideDrawable> glideAnimation) {
            myAlert.setIcon(resource);
        }
    });