editText.setOnKeyListener(
        new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                switch (keyCode) {
                    case KeyEvent.KEYCODE_P:
                        Toast.makeText(MyActivity.this, "P pressed", Toast.LENGTH_SHORT).show();
                        return true;
                    default:
                        return false;
                }
            }
        }
);