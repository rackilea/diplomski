....load(R.drawable.ic_search).into(new SimpleTarget(20, 20) {
    @Override public void onResourceReady(Bitmap icon, GlideAnimation glideAnimation) {
        for (int i = 0; i < 5; i++) {
            // load others using icon passed into the transformation
        }
    }
});