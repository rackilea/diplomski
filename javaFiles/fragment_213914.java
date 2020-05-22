ArrayList<String> mMovies;
int DETAIL_REQUEST_CODE = 123;
String KEY_FAVORITE_MOVIES = "key-movies";

private void startDetailActivity() {
    Intent intent = new Intent(this, DetailActivity.class);
    intent.putStringArrayListExtra(KEY_FAVORITE_MOVIES, mMovies);
    startActivityForResult(intent, DETAIL_REQUEST_CODE);
}

@Override
protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    if (requestCode == DETAIL_REQUEST_CODE && resultCode == RESULT_OK) {
        mMovies = data.getStringArrayListExtra(KEY_FAVORITE_MOVIES);
    }
}