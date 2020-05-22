@Override
public boolean onOptionsItemSelected(MenuItem item) {
    ...
    switch (item.getItemId()) {

        case R.id.complete:
            ....
            break; // -> You must add this line.
        case R.id.inprogress:
            ...
            break; // -> You must add this line.
    }
    ...
}