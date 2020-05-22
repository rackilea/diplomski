public class MyActivity extends Activity {
 ...

 static final int PICK_CONTACT_REQUEST = 0;

 protected boolean onKeyDown(int keyCode, KeyEvent event) {
     if (keyCode == KeyEvent.KEYCODE_DPAD_CENTER) {
         // When the user center presses, let them pick a contact.
         startActivityForResult(
             new Intent(Intent.ACTION_PICK,
             new Uri("content://contacts")),
             PICK_CONTACT_REQUEST);
        return true;
     }
     return false;
 }

 protected void onActivityResult(int requestCode, int resultCode,
         Intent data) {
     if (requestCode == PICK_CONTACT_REQUEST) {
         if (resultCode == RESULT_OK) {
             // A contact was picked.  Here we will just display it
             // to the user.
             startActivity(new Intent(Intent.ACTION_VIEW, data));
         }
     }
 }
}