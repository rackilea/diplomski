editText.addTextChangedListener(new TextWatcher() {

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
        }

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count,
                int after) {
        }

        @Override
        public void afterTextChanged(Editable s) {
            if (s.charAt(s.length() - 1) == '\n') {
                  Log.d("TEST RESPONSE", "Enter was pressed");
            }
        }
    });