editText.addTextChangedListener(new TextWatcher() {

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            // TODO Auto-generated method stub

        }

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            // TODO Auto-generated method stub

        }

        @Override
        public void afterTextChanged(Editable s) {
            String string = s.toString();
            int index = -1;
            while (((index = string.indexOf(' ', index + 1)) != -1) && (index + 1 < string.length())) {
                // Get character
                char c = string.charAt(index + 1);
                if (Character.isLowerCase(c)) {

                    // Replace in editable by uppercase version
                    s.replace(index+1, index + 2, Character.toString(c).toUpperCase());
                }
            }
        }
    });