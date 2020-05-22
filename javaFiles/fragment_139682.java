Glide
.with(getApplicationContext())
.load("https://www.google.es/images/srpr/logo11w.png")
.asBitmap()
.into(new SimpleTarget<Bitmap>(100,100) {
    @Override
    public void onResourceReady(Bitmap resource, GlideAnimation glideAnimation) {
        gravityView.setImage(imageView, resource)
    }
});