String[] from = new String[] {
        ContactsContract.Contacts.DISPLAY_NAME,
        ContactsContract.CommonDataKinds.Phone.NUMBER
};
autoContacts=(AutoCompleteTextView)findViewById(R.id.autoCompleteTextView1);
Cursor emailCursor = getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null, null, null, null);
startManagingCursor(emailCursor);
SimpleCursorAdapter adapter =new SimpleCursorAdapter(this, android.R.layout.simple_dropdown_item_1line, emailCursor, from, new int[] {android.R.id.text1}); 
adapter.setCursorToStringConverter(new CursorToStringConverter() {              
        @Override
        public CharSequence convertToString(Cursor cursor) {
            final int columnIndex = cursor.getColumnIndexOrThrow(ContactsContract.CommonDataKinds.Phone.NUMBER);
            final String str = cursor.getString(columnIndex);
            return str;
        }
});
autoContacts.setAdapter(adapter);
autoContacts.setThreshold(0);