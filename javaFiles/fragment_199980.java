editText.addTextChangedListener(new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable s) {
            String string = s.toString();
            Log.d("STRING", string + " " + prevString);
            if (string.equals(prevString)) {
                return;
            } else if (string.length() == 0)
                return;
            // 1st character
            else if (string.length() == 1) {
                prevString = string.toUpperCase();
                editText.setText(string.toUpperCase());
                editText.setSelection(string.length());
            }
            // if the last entered character is after a space 
            else if (string.length() > 0 && string.charAt(string.length() - 2) == ' ') {
                string = string.substring(0, string.length() - 1) + Character.toUpperCase(string.charAt(string.length() - 1));
                prevString = string;
                editText.setText(string);
                editText.setSelection(string.length());
            }
        }
    });