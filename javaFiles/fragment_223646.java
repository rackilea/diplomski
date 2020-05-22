InputFilter usernameFilter = new InputFilter() {
        @Override
        public CharSequence filter(CharSequence source, int start, int end, Spanned dest, int dstart, int dend) {
            String blockCharacterSet = " اآبپتثجچحخدذرزژسشصضطظعغفقکگلمنوهی";
            if (blockCharacterSet.contains(source)) {
                edtNameEdit.setHintTextColor(getResources().getColor(R.color.grey));
                edtNameEdit.setHint("نام و نام خانوادگی");
                return source.toString();
            } else {
                edtNameEdit.setHintTextColor(getResources().getColor(R.color.sPink));
                edtNameEdit.setHint("نام و نام خانوادگی باید فارسی باشد!");
                return "";
            }
        }
    };
    edtNameEdit.setFilters(new InputFilter[]{usernameFilter});