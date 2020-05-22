if ((a.getText().toString().equals("")) || (b.getText().toString().equals("")) || (c.getText().toString().equals("")))
    Toast.makeText(getApplicationContext(), "Don't leave grade points empty",0).show();
else {
    //Convert your a/b/c.getText() to a1/b1/c1 now you know they are not empty
    if((a1<5 || a1>10)||(b1<5 || b1>10)||(c1<5 || c1>10))
        Toast.makeText(getApplicationContext(), "Range should be between 15 to 25", 0).show();
    else
    {
    //do something
    }
}