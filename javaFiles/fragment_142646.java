this.etName = root.findViewById(R.id.yourEtID); // I'm sure you're doing something very similar to this in your VH's constructor
this.etName.addTextChangedListener(new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

       }
        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        }
        @Override
        public void afterTextChanged(Editable editable) {
            System.out.println(etName.getTag());
        }
    });