EditText yourEditText = (EditText)findViewById(R.id.editTextNew);

 yourEditText.addTextChangedListener(new TextWatcher() {

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {}
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count,int after) {}

        @Override
        public void afterTextChanged(Editable s) {
            if(s.length() >= 200){
                // Show your Button now ...
            }
        }
    });