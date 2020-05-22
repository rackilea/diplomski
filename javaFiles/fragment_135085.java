AlbumArtCache cache = AlbumArtCache.getInstance();
Bitmap art = cache.getIconImage(url);
if (art == null) {
  cache.fetch(url, new AlbumArtCache.FetchListener() {
            @Override
            public void onFetched(String artUrl, Bitmap bitmap, Bitmap icon) {
                if (artUrl.equals(url)) {
                    holder.mImageView.setImageBitmap(icon);
                }
            }
        });
} else {
    holder.mImageView.setImageBitmap(bitmap);
}