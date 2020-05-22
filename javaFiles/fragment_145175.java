//on fragment back pressed
    view.setFocusableInTouchMode(true);
    view.requestFocus();
    view.setOnKeyListener(new View.OnKeyListener() {
        @Override
        public boolean onKey(View v, int keyCode, KeyEvent event) {
            if (keyCode == KeyEvent.KEYCODE_BACK  && event.getAction()== KeyEvent.ACTION_DOWN) {
               // do your code on back pressed
                return true;
            }
            return false;
        }
    });