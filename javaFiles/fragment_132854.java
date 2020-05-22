EditText et = (EditText) findViewById(YOUR_EDITTEXT);
    String s = et.getText().toString();
    if(s.length() <= 10){
        et.setError("Must exceed 10 characters!");
    } else {
        // ...
    }