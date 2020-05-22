public class RetrofitImageLoader extends AsyncTask<InputStream, Integer, Bitmap> {
        private ImageView imageView;

        private RetrofitImageLoader(ImageView imageView) {
            this.imageView = imageView;
        }

        @Override
        protected Bitmap doInBackground(InputStream... inputStreams) {
            return BitmapFactory.decodeStream(inputStreams[0]);
        }

        @Override
        protected void onPostExecute(Bitmap bitmap) {
            super.onPostExecute(bitmap);
            imageView.setImageBitmap(bitmap);
        }
}