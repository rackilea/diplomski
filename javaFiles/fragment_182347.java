public void onTextChanged(CharSequence s, int start, int before, int count) {
            EditText editText = findViewById(R.id.editText);
            int lineCount = editText.getLineCount();
            double digits = Math.log10(lineCount) +1;
            double digitsFloor = Math.floor(digits);
            double size = digitsFloor *20;
            showLnNum.setWidth((int) size);
            showLnNum.setText("");
            for (int i = 1; i <= editText.getLineCount(); i++)showLnNum.append(i + "\n");
    }