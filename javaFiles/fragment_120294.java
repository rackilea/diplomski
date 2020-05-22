Glide.with(getActivity())
    .load(url)
    .asBitmap()
    .into(new SimpleTarget<Bitmap>(100, 100) {
        @Override
        public void onResourceReady(Bitmap bitmap, GlideAnimation anim) {
            // Do something with bitmap here
        }
    };