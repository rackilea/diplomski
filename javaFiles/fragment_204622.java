Picasso.with(this)
    .load(imageUrl)
    .fit()
    .centerInside()
    .into(imageViewFromUrl, new Callback() {
        @Override
        public void onSuccess() {
            Log.i(TAG, "succcess");
        }

        @Override
        public void onError() {
            Log.i(TAG, "error");
        }
    }
);