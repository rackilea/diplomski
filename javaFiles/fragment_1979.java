String word = "very";

TextWatcher watcher = new TextWatcher() {
    public void onTextChanged(CharSequence s, int start, int before, int count) {
    }

    public void beforeTextChanged(CharSequence s, int start, int count,
            int after) {
    }

    public void afterTextChanged(Editable s) {
        String tmp = s.toString().trim().toLowerCase();
        if(tmp.contains(word.toLowerCase())){
            //inform the user here
        }
    }
};