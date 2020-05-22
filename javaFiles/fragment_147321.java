EditText[] rEdit = new EditText[25];

for (int i = 0; i < 25; i++) {
    EditText editText = (EditText) findViewById(getResources()
        .getIdentifier("yourViewName" + i, "id", getPackageName()));
    rEdit[i] = editText;
}