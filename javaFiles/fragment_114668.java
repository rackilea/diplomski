Glide.with(this).load(imagePath).asBitmap().into(new SimpleTarget<Bitmap>(viewWidth, viewHeight) {
                    @Override
                    public void onResourceReady(Bitmap resource, GlideAnimation<? super Bitmap> glideAnimation) {
                        Drawable drawable = new BitmapDrawable(resource);
                            yourImageButton.setBackground(drawable);
                    }
});