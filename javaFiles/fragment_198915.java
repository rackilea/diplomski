int ACTION_PICK_CONTACT=1;

//Call this in your onclick event
Intent i = new Intent(Intent.ACTION_PICK, ContactsContract.Contacts.CONTENT_URI);
startActivityForResult(i, ACTION_PICK_CONTACT);

//This is called when user has selected a contact
public void onActivityResult(int reqCode, int resCode, Intent data) {
   super.onActivityResult(reqCode, resultCode, data);

   switch (reqCode) {
     case (ACTION_PICK_CONTACT) :
        if (resCode == Activity.RESULT_OK) {

          Uri contact = data.getData();
          Cursor cursor =  managedQuery(contact, null, null, null, null);
          if (cursor.moveToFirst()) {
            String contact_id =cursor.getString(c.getColumnIndexOrThrow(ContactsContract.Contacts._ID));

            Cursor phoneCursor = getContentResolver().query( 
                   ContactsContract.CommonDataKinds.Phone.CONTENT_URI,null, 
                   ContactsContract.CommonDataKinds.Phone.CONTACT_ID +" = "+ contact_id, 
                   null, null);
            phoneCursor.moveToFirst();
            String phoneNumber = phoneCursor.getString(phoneCursor.getColumnIndex("data1")); //THE NUMBER TO SEND YOUR SMS
            txtPhoneNo.setText(phoneNumber);
          }
        }
        break;
    }
}