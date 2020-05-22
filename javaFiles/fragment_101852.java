@Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        switch (keyCode) {
        case KeyEvent.KEYCODE_MENU:
            Toast.makeText(getApplicationContext(), "Do what you want to show here", Toast.LENGTH_SHORT).show();
            break;

        }
        return true;
    }