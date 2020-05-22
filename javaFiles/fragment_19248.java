protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    if (requestCode == 1) {
        if (resultCode == RESULT_OK) {
            Uri result = data.getData();  
           String id = result.getLastPathSegment();
            String projection[] = { Phone.NUMBER };
            Cursor c = getContentResolver().query(Phone.CONTENT_URI, projection,
                    Phone.CONTACT_ID + "=?", new String[] { id }, null);
            c.moveToFirst();
            int column = c.getColumnIndex(Phone.NUMBER);
            String number = c.getString(column);
            Toast.makeText(this,
                    "The number of selected contact is:-" + number,
                    Toast.LENGTH_LONG).show();

        }
    }
}