Intent intent = getIntent();
    boolean registers = getIntent().getExtras().getBoolean("isRegister");
    if(!registers)
    {
        Toast.makeText(LoginActivity.this, "You need to verify your email address before signing 
        in!", Toast.LENGTH_LONG).show();
    }