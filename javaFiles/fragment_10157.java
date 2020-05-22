@Override
public boolean onOptionsItemSelected(final MenuItem item) {
    switch(item.getItemId()) {
        case R.id.action_search:
            TransitionManager.beginDelayedTransition((ViewGroup) getActivity().findViewById(R.id.toolbar));
            MenuItemCompat.expandActionView(item);
            return true;
    }
    return super.onOptionsItemSelected(item);
}