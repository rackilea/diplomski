yourEditBox.setOnKeyListener(new OnKeyListener() {
        @Override
        public boolean onKey(View v, int keyCode, KeyEvent event) {
            if (event.getKeyCode() == KeyEvent.KEYCODE_ENTER) {
                // intercept the return key
                return true;
            }
            return false;
        }

    });