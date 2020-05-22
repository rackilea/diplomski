Button startButton = (Button) findViewById(R.id.startButton);
startButton.setOnClickListener(new View.OnClickListener()
{
    public void onClick(View view)
    {
        username = usernameField.getText().toString();
        password = passwordField.getText().toString();
        Intent myIntent = new Intent(view.getContext(), HttpGetPost.class);
        // ADDITION
        myIntent.putExtra("username", username);
        myIntent.putExtra("password", password);
        // END ADDITION
        startActivityForResult(myIntent, 0);
    }
});