@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    // your view binding code with findViewById
    // ...

    // here you're trying to read the EditText value,
    // but no user input yet because you've only inflate it before.
    final String plntxt= plainText.getText().toString();
    final String noOflines= noOfLines.getText().toString();
    // the noOfLines is "", an empty string.
    int lines = 0;
    try {
        // this raise an exception because empty string is not number.
        lines = Integer.parseInt(noOflines);
    }
    catch (NumberFormatException e){

    }

    ...
}