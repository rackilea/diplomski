public final class Connection extends AsyncTask<String, Void, String> {

    private final WeakReference<ImageView> imageViewRef;

    public Connection(ImageView view) {
        imageViewRef = new WeakReference<ImageView>(view);
    }

    @Override
    protected String doInBackground(String... arg0) {
        // TODO Auto-generated method stub
                //...

        return "a string";
    }

    @Override
    protected void onPostExecute(String result) {
        super.onPostExecute(result);
                //...

        final ImageView imageView = imageViewRef.get();
        // if the Activity is still alive, the ImageView will not be null
        if (imageView != null) {
            // set an image or whatever you need
            image.setImageResource(666);
        }

    }