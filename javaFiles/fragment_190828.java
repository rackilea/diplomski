TypedArray fields = getResources().obtainTypedArray(R.array.fields);
for (int i = 0; i < fields.length(); i++) {
    EditText editText = findViewById(fields.getResourceId(i, 0));
    editText.setText("Yo!"); // or something else
}
fields.recycle();