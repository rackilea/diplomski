calculate.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        String value = numbers.getText().toString();
        char[] chars = value.toCharArray();
        int total = 0;
        for (int i = 0; i < chars.length; i++) {
            int parsedInt = Character.getNumericValue(chars[i]);
            if (parsedInt >= 0) {
                total += parsedInt;
            }
        }
        if (total > 0) {
            result.setText(Integer.toString(total));
        } else {
            result.setText("");
        }
    }
});