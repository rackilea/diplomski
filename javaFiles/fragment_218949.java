editText.addTextChangedListener(new TextWatcher() {
        final String FUNCTION = "function";
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {}

        @Override
        public void afterTextChanged(Editable s) {
            int index = s.toString().indexOf(FUNCTION);
            if (index >= 0) {
                s.setSpan(
                        new ForegroundColorSpan(Color.CYAN),
                        index,
                        index + FUNCTION.length(),
                        Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            }
        }
    });