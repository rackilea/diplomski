@Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode == KeyEvent.KEYCODE_BACK)
        {
            showResults(0);
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }