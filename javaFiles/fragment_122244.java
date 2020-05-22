profile_name.addTextChangedListener(new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) { }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) { }

        @Override
        public void afterTextChanged(Editable s) {
            String str = s.toString();
            if (!(str.matches("[a-zA-Z0-9-_ ]*"))) {
                str = removeIllegalChar(str).trim(); //trim whitespaces
                profile_name.setText(str);
                profile_name.setSelection(str.length());  //use only if u want to set cursor to end
            }
        }
    });

    private String removeIllegalChar(String str) {
    for (int i=0; i < str.length(); i++) {
        if (!(String.valueOf(str.charAt(i)).matches("[a-zA-Z0-9-_ ]*"))) {
            //as the callback is called for each character entered, we can return on first non-match
            //maybe show a short toast        
            return str.substring(0, i) + str.substring(i+1);
        }
    }
    return str;
}