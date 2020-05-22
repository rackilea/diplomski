public boolean onQueryTextChange(String newText) {
    FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
    SearchMovieFragment searchMovieFragment = new SearchMovieFragment();
    Bundle bundle = new Bundle();
    if(newText.length()>0) {
        bundle.putString("query", newText);
    } else {
        bundle.putString("query", "");
    }
    searchMovieFragment.setArguments(bundle);
    transaction.replace(R.id.frame_container,searchMovieFragment);
    transaction.commit();
    return true;
}