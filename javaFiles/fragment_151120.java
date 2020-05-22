if(password.equals(storedPassword))
    {
        Toast.makeText(HomeActivity.this, "Congrats: Login Successfull",          Toast.LENGTH_LONG).show(); 
        Intent intentLetterChecker=new Intent(MainActivity.this,HomeActivity.class);
        startActivity(intentLetterChecker);
    }