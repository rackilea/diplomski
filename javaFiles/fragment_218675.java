public class BookLoader extends AsyncTaskLoader<List<Book>> {
        String baseRequestUrl;
        public BookLoader(Context context, String baseRequestUrl) {
            super(context);
            this.baseRequestUrl=baseRequestUrl;
        }

        @Override
        protected void onStartLoading() {
            super.onStartLoading();
            forceLoad();
        }

        @Override
        public List<Book> loadInBackground() {
             //user url here
            /** Tag for log messages */
             String LOG_TAG = BookLoader.class.getName();
            final String APP_ID = "booklisting-174212";
            Log.e( " REQUEST is: trial 2 : "+baseRequestUrl );
            BASE_REQUEST_URL += key;
            Log.e(LOG_TAG, " Request url : "+BASE_REQUEST_URL );
            return null;
        }
}