WorkerThread mWorkerThread = new WorkerThread(mImageView);
mWorkerThread.execute(src);


private class WorkerThread extends AsyncTask<String, String, Bitmap> {
    private WeakReference<ImageView> imageViewReference;

    public WorkerThread(ImageView imageView) {
        super();
        imageViewReference = new WeakReference<ImageView>(imageView);
    }

    @Override
    protected Bitmap doInBackground(String... args) {
        Bitmap bitmap = null;
        try {
            bitmap = BitmapFactory.decodeStream((InputStream) new URL(args[0]).getContent());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bitmap;
    }

    @Override
    protected void onPostExecute(Bitmap result) {
        super.onPostExecute(result);
        if (result != null && imageViewReference.get() != null) {
            imageViewReference.get().setImageBitmap(result);
        }
    }

}