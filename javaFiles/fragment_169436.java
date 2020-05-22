if (Username.equals(TakenUsername))

            {
                Toast.makeText(getApplicationContext(), "Username Already Taken",
                        Toast.LENGTH_LONG).show();
                return;
            } else {
                // Save data in database
                db.insertPlayer(Username, Password, Email);
                Toast.makeText(getApplicationContext(), "Account Successfully Created ",
                        Toast.LENGTH_LONG).show();
                startActivity(new Intent("com.fullfrontalgames.numberfighter.Login"));
            }