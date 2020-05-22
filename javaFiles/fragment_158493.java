@Override
        public void afterTextChanged(Editable s) {
            String value = s.toString();
            editText.removeTextChangedListener(this);
            String fixedValue = getDecimalFormattedString(value);
            int preSelection = editText.getSelectionEnd();
            s.replace(0, value.length(), fixedValue);
            editText.setSelection(preSelection + fixedValue.length() - value.length());
            editText.addTextChangedListener(this);
        }