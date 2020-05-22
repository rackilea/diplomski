List<EditText> editTextList = new ArrayList<>();
for (int i = 4; i <= 65; i++) {
      EditText editText = (EditText) findViewById(
               getResources().getIdentifier("f1text" + i, "id", "package_name"));
      editTextList.add(editText);
}