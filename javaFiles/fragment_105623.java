@Override
public boolean onOptionsItemSelected(MenuItem item) {
    switch (item.getItemId()) {
        case android.R.id.home:
            getFragmentManager().popBackStack();
            Toast.makeText(getActivity(),"CLick",Toast.LENGTH_SHORT).show();
            return true; //Notice you must returning true here

        default:
            return super.onOptionsItemSelected(item);
    }
}