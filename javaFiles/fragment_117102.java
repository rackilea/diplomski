edit.addTextChangedListener(new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            if (i2 < i1) {
                mainAd.resetData();  //if I delete characters I would like to show the original list
            }
            mainAd.getFilter().filter(charSequence.toString());
        }

        @Override
        public void afterTextChanged(Editable editable) {

        }
    });