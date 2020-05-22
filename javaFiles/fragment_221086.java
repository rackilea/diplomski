private void loadImage(Context context, String url, ImageView imageView, int x1, int y1, int x2, int y2) {
    Glide.with(context)
       .load(url)
       .asBitmap()
       .into(new SimpleTarget<Bitmap>(Target.SIZE_ORIGINAL, Target.SIZE_ORIGINAL) {
        @Override
        public void onResourceReady(Bitmap resource, GlideAnimation glideAnimation) {
            Bitmap cropeedBitmap = Bitmap.createBitmap(resource, x1, y1, x2, y2);
            imageView.setImageBitmap(cropeedBitmap);
        }
    });
}