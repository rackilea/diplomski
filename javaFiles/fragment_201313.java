@Override
    public void onClick(View v) {

        String grabFirstname = UsernameET.getText().toString();
        String grabSurname = SurnameET.getText().toString();
        String grabEmail = EmailET.getText().toString();
        String grabPassword = PasswordET.getText().toString();
        String grabCountry = CountryDrop.getSelectedItem().toString();

        DatabaseHelper helper = new DatabaseHelper(context); //replace context with your activity context. "this" would refer to your onClickListener so be careful.

        helper.sampleMethod(new String[]{
           "user",
           "pass",
           "foo",
           "bar",
           ...
        });

      //rest of your code
    }