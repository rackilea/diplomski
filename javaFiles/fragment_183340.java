public void afterTextChanged(Editable s) {
    if (s.length() == 0) {
        textView_name.setVisibility(View.GONE);
     } else {
        textView_name.setText("You have entered : " + s.toString());
     }

    if (s.toString().equals(context.getString(R.string.editText_7)) {
        Toast.makeText(getApplication().getBaseContext(),
               (R.string.Good),Toast.LENGTH_SHORT).show();
    }
}