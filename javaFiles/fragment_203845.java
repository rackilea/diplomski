public void RevOnClick(View view)
{
    EditText main2EditText1 =(EditText)findViewById(R.id.main2EditText1);
    String sen = main2EditText1.getText().toString();
    String[] senRev = sen.split("\\b");

    // use a StringBuilder to assemble the reversed sentence
    StringBuilder result = new StringBuilder();

    for (int n = senRev.length - 1; n >= 0; n--)  
    {       
        // append each word 
        result.append(senRev[n]);

        if (n > 0) {
            // if there are more words add a ' '
            result.append(" ");
        }
    }

    TextView main2TextView1 = (TextView)findViewById(R.id.main2TextView1);
    main2TextView1.setText(result.toString());
}