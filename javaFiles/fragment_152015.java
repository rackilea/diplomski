usernameInput = (EditText) findViewById(R.id.username); // inOncreateview

    // Somewhere in method
    float a;

    try{
if(!usernameInput.getText().toString().equalsignorecase(""))
    a = Float.parseFloat(usernameInput.getText().toString());
    }catch(NumberFormatException e){
    log.d("Error","Not Convertible");
    e.printstacktrace();
    }