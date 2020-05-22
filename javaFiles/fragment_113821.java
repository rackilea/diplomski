public void onActivityResult (int requestCode, int resultCode, Intent intent) {
    super.onActivityResult (requestCode, resultCode, intent);

    switch (resultCode)
    case 123:
        // hide button 1
    case 234:
        // hide button 2
    // etc...
}