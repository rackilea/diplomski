if (phoneCursor != null) {
    if (phoneCursor.moveToNext()) {
         String phoneNumber = phoneCursor.getString(phoneCursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));

          contacts.add(new ContactsHelper(name, phoneNumber));
          phoneCursor.close();

          ....... (Write Here)

     }
}