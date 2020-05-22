public class PhotoGalleryImageAdapter extends BaseAdapter {

    private Context mContext;
    private PhotoGalleryModel[] photoGalleryModels;
    private LruCache<String, Bitmap> mMemoryCache;

    public PhotoGalleryImageAdapter(Context c, PhotoGalleryModel[] models){
        mContext = c;
        photoGalleryModels = models;

        final int maxMemory = (int)(Runtime.getRuntime().maxMemory() / 1024);
        final int cacheSize = maxMemory / 8;

        mMemoryCache = new LruCache<String, Bitmap>(cacheSize) {
            @Override
        protected int sizeOf(String key, Bitmap bitmap) {
                return bitmap.getByteCount() / 1024;
            }
        };
    }

    @Override
    public int getCount() { return photoGalleryModels.length; }

    @Override
    public Object getItem(int position) { return null; }

    @Override
    public long getItemId(int position) { return 0; }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        final ImageView imageView = new ImageView(mContext);
        final String imageKey = photoGalleryModels[position].thumb_image_url;
        final Bitmap bitmapImage = mMemoryCache.get(imageKey);

        if (bitmapImage != null) {
            imageView.setImageBitmap(bitmapImage);
        }
        else {

            DownloadImageWithURL(photoGalleryModels[position].thumb_image_url, new MyHttpCallback() {
                @Override
                public void MyHttpCallback_OnSuccess(Object data, String responseString) {
                    if (data instanceof Bitmap) {
                        mMemoryCache.put(imageKey, (Bitmap)data);
                        imageView.setImageBitmap((Bitmap)data);
                    }
                }

                @Override
                public void MyHttpCallback_OnError(String responseString, ErrorDataModel error)
                {}
            });
        }

        convertView = imageView;
        return convertView;
    }

}