public View onCreateView(LayoutInflater inflater, ViewGroup container,
                         Bundle savedInstanceState) {
   .............
  .............
 .............
setHasOptionsMenu(true);
.................
.................
 }


@Override
public void onCreateOptionsMenu(
        Menu menu, MenuInflater inflater) {
    inflater.inflate(R.menu.menu_main, menu);
}


@Override
public boolean onOptionsItemSelected(MenuItem item) {
    // handle item selection
    switch (item.getItemId()) {
        case R.id.airport_menuRefresh:

              TopRatedFragment.this.myWebView2.loadUrl("http://myexample.com");
            return true;
        default:
            return super.onOptionsItemSelected(item);
    }
}