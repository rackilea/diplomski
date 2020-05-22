mEditText.setOnKeyListener(new OnKeyListener() {           

    @Override
    public boolean onKey(View v, int keyCode, KeyEvent event) {

        if (event.getAction() == KeyEvent.ACTION_DOWN && 
            keyCode == KeyEvent.KEYCODE_ENTER) {

            // do what you do in "Okay" button
            return true;
        }
        return false;
    }
});