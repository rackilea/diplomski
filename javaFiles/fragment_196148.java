private void sendStuff(Context context, String[] params) {
    RESTGet restGet = new RESTGet(context) {
        @Override
        protected void onPostExecute(String feed) {
            super.onPostExecute(feed);
            this.stopMessageLoading();
            Intent intent = new Intent(context, ShowPictures.class);
            ((Activity)context).startActivity(intent);
        }
    }.execute(params);
}