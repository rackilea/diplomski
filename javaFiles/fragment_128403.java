if (TextUtils.isEmpty(firstname))
{
    Toast.makeText(Signup.this, "Enter your first name.", Toast.LENGTH_LONG).show();
} else if (TextUtils.isEmpty(lastname))
{
    Toast.makeText(Signup.this, "Enter your last name.", Toast.LENGTH_LONG).show();
} else if (TextUtils.isEmpty(email))
{
    Toast.makeText(Signup.this, "Enter your valid email address.", Toast.LENGTH_LONG).show();
}else if (TextUtils.isEmpty(password))
{
    Toast.makeText(Signup.this, "Enter your password.", Toast.LENGTH_LONG).show();
} else if (TextUtils.isEmpty(confirmpass)) {
    Toast.makeText(Signup.this, "Please write your password again.", Toast.LENGTH_LONG).show();
}else if (password != confirmpass)
{
    Toast.makeText(Signup.this, "Password do not match", Toast.LENGTH_LONG).show();
}