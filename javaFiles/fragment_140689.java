final EditText editText= (EditText) findViewById(R.id.edittext);
final Button button = (Button) findViewById(R.id.button);
    button.setOnClickListener(new View.OnClickListener() {
        public void onClick(View v) {
            int val = Integer.parseInt(editText.getText().toString());
        }
            // Perform action on click
        }