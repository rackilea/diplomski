@Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        Toast.makeText(getApplicationContext(), "Fired", Toast.LENGTH_LONG).show();
        if (keyCode == KeyEvent.KEYCODE_SEARCH) {
            Toast.makeText(getApplicationContext(), "Search Key Fired", Toast.LENGTH_LONG).show();
            return true;
        }
        return super.onKeyDown(keyCode, event);
     }