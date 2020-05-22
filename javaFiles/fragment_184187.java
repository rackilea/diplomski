ViewTarget viewTarget = new ViewTarget<SubsamplingScaleImageView, Drawable>(image_view) {
            @Override
            public void onResourceReady(@NonNull Drawable resource, @Nullable Transition<? super Drawable> transition) {
                Bitmap mutableBitmap = Bitmap.createBitmap(resource.getIntrinsicWidth(), resource.getIntrinsicHeight(), Bitmap.Config.RGB_565);
                Canvas canvas = new Canvas(mutableBitmap);
                resource.setBounds(0, 0, resource.getIntrinsicWidth(), resource.getIntrinsicHeight());
                resource.draw(canvas);

                this.view.setImage(ImageSource.bitmap(mutableBitmap));
            }
        };