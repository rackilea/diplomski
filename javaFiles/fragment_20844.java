private class GalleryHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private ImageView mImageView;
        private TextView mTextView;
        ....
        com.squareup.picasso.Target target = new com.squareup.picasso.Target() {
            @Override
            public void onBitmapLoaded(Bitmap bitmap, Picasso.LoadedFrom from) {
                mTextView.setBackgroundColor(Color.RED);
                mImageView.setImageBitmap(bitmap);
            }

            @Override
            public void onBitmapFailed(Drawable errorDrawable) {}

            @Override
            public void onPrepareLoad(Drawable placeHolderDrawable) {}
        };
        ....
        public void bindImage(GalleryItem item ){
            Picasso.with(MainActivity.this).load(item.getThumbnail()).tag(MainActivity.this).into(target);
        }
    }