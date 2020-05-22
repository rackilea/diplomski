final String permission = textInputEditTextPermission.getText().toString().trim();
final String email = textInputEditTextEmail.getText().toString().trim();

emptyInputEditText();

if (permission.equals("1")) {
    accountsIntent = new Intent(activity, UsersListActivity.class);
} else if (permission.equals("2")) {
    accountsIntent = new Intent(activity, OtherActivity.class);
} else {
    accountsIntent = new Intent(activity, AnotherActivity.class);
}

accountsIntent.putExtra("EXTRA_EMAIL", email);   
startActivity(accountsIntent);