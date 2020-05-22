// get reference to the TextView
    final TextView display = (TextView) findViewById(R.id.textView1);

    // get reference to EditText and set listener to update TextView
    final EditText input = (EditText) findViewById(R.id.editText1);
    input.setOnKeyListener(new OnKeyListener() {
        @Override
        public boolean onKey(View v, int keyCode, KeyEvent event) {
            if ((event.getAction() == KeyEvent.ACTION_DOWN) &&
                    (keyCode == KeyEvent.KEYCODE_ENTER)) {
                  display.setText(input.getText());
                  return true;
                }
                return false;
        }
    });