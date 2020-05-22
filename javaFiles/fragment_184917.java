public class LoadTask extends AsyncTask<Void, Void, Integer> {

    public interface Callback {
        void onPhotoCount(int count);
    }

    private final Callback callback;

    public LoadTask(Callback callback) {
         this.callback = callback;
    }

    protected Integer doInBackground(Void... params) {
        return photosDao.getPersistedPhotosSize();
    }

    protected void onPostExecute(Integer result) {
         callback.onPhotoCount(result);
    }

}

...

new LoadTask(photoCount -> {
    // Do stuff with value,e.g. update ui.
}).execute();