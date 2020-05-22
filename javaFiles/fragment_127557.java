loginButton.setOnClickListener(new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            DatabaseConnector db = new DatabaseConnector(context);
            db.open();
            String storedPassword = db.checkLogin(strUsername);
            db.close();

            if (storedPassword.equalsIgnoreCase(strPassword)) {
                Toast.makeText(getApplicationContext(), "Success!",
                        Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(getApplicationContext(), "Error!",
                        Toast.LENGTH_LONG).show();
            }

        }

    });