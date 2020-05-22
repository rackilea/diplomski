@Override
public boolean onOptionsItemSelected(MenuItem item) {
    // User clicked on a menu option in the app bar overflow menu
    int id = item.getItemId();

    switch (item.getItemId()) {
        case R.id.most_popular:
           parseMovieJSON(Constants. POPULAR_URL);
           break;

        case R.id.top_rated:
            setTitle("TOP RATED");
            // return Top rated Movies list from API 
            parseMovieJSON(Constants.HIGH_RATED_URL);
            break;
    }
    return super.onOptionsItemSelected(item);
}