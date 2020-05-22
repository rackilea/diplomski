final EditText et = findViewById(R.id.edittext);
et.setOnKeyListener(new View.OnKeyListener() {
    @Override
    public boolean onKey(View view, int i, KeyEvent event) {
        // onKey is fired twice, we filter one out
        if (event.getAction()!=KeyEvent.ACTION_UP) {
            return false;
        }

        if (event.getKeyCode() == KeyEvent.KEYCODE_ENTER) {
            String oldString = et.getText().toString();
            String newString =  oldString + "\u25CF";
            et.setText(newString);
            et.setSelection(et.getText().length());
        }
        return false;
    }
});