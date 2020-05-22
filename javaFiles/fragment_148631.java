ContentResolver cr = getContentResolver(); 
Cursor cur = cr.query(ContactsContract.Contacts.CONTENT_URI, null, null, null, null); 
String phone = null;
if (cur.getCount() > 0) { 
  while (cur.moveToNext()) { 
    String id = cur.getString(cur .getColumnIndex(ContactsContract.Contacts._ID)); 
    if (Integer .parseInt(cur.getString(cur.getColumnIndex(ContactsContract.Contacts.HAS_PHONE_NUMBER))) > 0) 
    { 
      Cursor pCur = cr.query( ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null, ContactsContract.CommonDataKinds.Phone.CONTACT_ID + " = ?", new String[] { id }, null); 
      while (pCur.moveToNext()) { 
        phone = pCur .getString(pCur .getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER)); 
        // This was the phone number for that contact id...
      } 
    pCur.close(); 
    Cursor emailCur = cr.query( ContactsContract.CommonDataKinds.Email.CONTENT_URI, null, ContactsContract.CommonDataKinds.Email.CONTACT_ID + " = ?", new String[] { id }, null);
    while (emailCur.moveToNext()) { 
    // For Email
      emailContact = emailCur .getString(emailCur .getColumnIndex(ContactsContract.CommonDataKinds.Email.DATA)); 
      emailType = emailCur .getString(emailCur .getColumnIndex(ContactsContract.CommonDataKinds.Email.TYPE));
    } 
  } 
}