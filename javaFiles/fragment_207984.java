@Override
public void onBackPressed() {

    if (!chooserIsShowing) {
        // do something on back.
        Intent myIntent = new Intent(getApplicationContext(), MainActivity.class);
        startActivityForResult(myIntent, 0);
        finish();
    }

    // remove the flag
    chooserIsShowing = false;
    return;
}