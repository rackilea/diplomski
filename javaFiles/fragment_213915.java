public void finishDetail() {
    Intent resultIntent = new Intent();
    resultIntent.putStringArrayListExtra(KEY_FAVORITE_MOVIES, mMovies);
    setResult(Activity.RESULT_OK, resultIntent);
    finish();
}