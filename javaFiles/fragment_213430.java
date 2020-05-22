final EditText editText = (EditText) findViewById(R.id.textView);
    editText.setOnEditorActionListener(clickedEnter);

    Button button = (Button) findViewById(R.id.button);
    button.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            editText.onEditorAction(EditorInfo.IME_ACTION_DONE);
        }
    });