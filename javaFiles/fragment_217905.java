private void passCheck(@NonNull DocumentSnapshot snapshot)
{
    final String uPass = tPassword.getText().toString();
    final String storedPass = snapshot.getString("password");
    if (storedPass != null && storedPass.equals(uPass))
    {

         PrefUtilities.with(this).setUserLogin(true);       

        Intent intent = new Intent(SLogin.this, StudentCP.class);
        intent.putExtra(STUDENT_EMAIL, email);
        startActivity(intent);
    }
    else
    {
        Toast.makeText(SLogin.this, "Invalid Password!", Toast.LENGTH_LONG).show();
    }
}