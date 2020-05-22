EditText input = findInput(np);    
TextWatcher tw = new TextWatcher() {

        @Override
        public void onTextChanged(CharSequence s, int start, int before,
                int count) {}

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count,
                int after) {}

        @Override
        public void afterTextChanged(Editable s) {
                if (s.toString().length() != 0) {
                    Integer value = Integer.parseInt(s.toString());
                    if (value >= np.getMinValue()) {
                        np.setValue(value);
                    }
                }
        }
    };
input.addTextChangedListener(tw);