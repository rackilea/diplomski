Display display = getWindowManager().getDefaultDisplay();
Point size = new Point();
display.getSize(size);
int width = size.x; //width of screen in pixels
int height = size.y;//height of screen in pixels
Glide.with(context)
    .load(Uri.parse("file:///android_asset/imagefile"))
    .asBitmap()
    .fitCenter() //fits given dimensions maintaining ratio
    .into(new SimpleTarget(width,height) {
        // the constructor SimpleTarget() without (width, height) can also be used.
        // as suggested by, An-droid in the comments
        @Override
        public void onResourceReady(Bitmap resource, GlideAnimation glideAnimation) {
            memCache.put("imagefile", resource);
        }
    });