// define global variable for contacts permission
private static Boolean contactsGranted = false;
...
registerButton.setOnClickListener(v -> {
        String name = nameText.getText().toString().trim();
        String email = emailText.getText().toString().trim();
        String password = passwordText.getText().toString().trim();
});
...
 private void CheckContacts(String name, String email, String password) {
    if (ContextCompat.checkSelfPermission(registerActivity, Manifest.permission.READ_CONTACTS) != PackageManager.PERMISSION_GRANTED) {

        // Should we show an explanation?
        if (ActivityCompat.shouldShowRequestPermissionRationale(registerActivity, Manifest.permission.READ_CONTACTS)) {
            if (!name.isEmpty() && !email.isEmpty() && !password.isEmpty()) {
                // contacts permission is not granted, check phone permission
                contactsGranted = false;
                CheckPhone(name, email, password);
            } else {
                Toast.makeText(getApplicationContext(), R.string.please_enter_credentials, Toast.LENGTH_LONG).show();
            }
        } else {
            ActivityCompat.requestPermissions(registerActivity, new String[]{Manifest.permission.READ_CONTACTS}, MY_PERMISSIONS_REQUEST_READ_CONTACTS);
        }
    } else {
        if (!name.isEmpty() && !email.isEmpty() && !password.isEmpty()) {
            // contacts permission is granted, check phone permission
            contactsGranted = true;
            CheckPhone(name, email, password);
        } else {
            Toast.makeText(getApplicationContext(), R.string.please_enter_credentials, Toast.LENGTH_LONG).show();
        }
    }
}

private void CheckPhone(String name, String email, String password) {
    if (ContextCompat.checkSelfPermission(registerActivity, Manifest.permission.READ_PHONE_STATE) != PackageManager.PERMISSION_GRANTED) {

        // Should we show an explanation?
        if (ActivityCompat.shouldShowRequestPermissionRationale(registerActivity, Manifest.permission.READ_PHONE_STATE)) {
            // phone permission is not granted, call register and pass empty phone string
            register(name, email, password, "");
        } else {
            ActivityCompat.requestPermissions(registerActivity, new String[]{Manifest.permission.READ_PHONE_STATE}, MY_PERMISSIONS_REQUEST_READ_PHONE);
        }
    } else {
        // phone permission is granted, call register and pass empty getMyPhoneNumber
        register(name, email, password, getMyPhoneNumber());
    }
}
...
@Override
public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {

    String email = emailText.getText().toString().trim();
    String password = passwordText.getText().toString().trim();
    String name = nameText.getText().toString().trim();

    switch (requestCode) {
        case MY_PERMISSIONS_REQUEST_READ_CONTACTS:
            // If request is cancelled, the result arrays are empty.
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                // permission was granted, yay! Do the
                // contacts-related task you need to do.
                if (!name.isEmpty() && !email.isEmpty() && !password.isEmpty()) {
                    // contacts permission is granted, check phone permission
                    contactsGranted = true;
                    CheckPhone(name, email, password);
                } else {
                    // Prompt user to enter credentials
                    Toast.makeText(getApplicationContext(), R.string.please_enter_credentials, Toast.LENGTH_LONG).show();
                // permission denied, boo! Disable the
                // functionality that depends on this
                if (!name.isEmpty() && !email.isEmpty() && !password.isEmpty()) {
                    // contacts permission is not granted, check phone permission
                    contactsGranted = false;
                    CheckPhone(name, email, password);
                } else {
                    // Prompt user to enter credentials
                    Toast.makeText(getApplicationContext(), R.string.please_enter_credentials, Toast.LENGTH_LONG).show();
                }
            }
            break;
        case MY_PERMISSIONS_REQUEST_READ_PHONE:
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                // phone permission is granted, call register and pass empty getMyPhoneNumber
                register(name, email, password, getMyPhoneNumber());
            } else {
                // phone permission is not granted, call register and pass empty phone string
                register(name, email, password, "");
            }
            break;
    }
}
...
// Register
public void register(final String name, final String email, final String password, final String phone) {
...
if (contactsGranted) {
   updateContacts();
}