@Override
public void afterTextChanged(Editable s) {
    try {
        String str = String.format("%,d", Long.parseLong(s.toString()
                .replaceAll(",", "")));
        int pos = editText.getSelectionStart();

        editText.removeTextChangedListener(this);
        editText.setText(str);
        editText.setSelection(pos);
        editText.addTextChangedListener(this);
    } catch (NumberFormatException e) {
        e.printStackTrace();
    }
}