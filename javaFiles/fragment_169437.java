long id = db.insertPlayer(Username, Password, Email);
if (id == -1)
{
    Toast.makeText(getApplicationContext(), "Username Already Taken",
                        Toast.LENGTH_LONG).show();
}