@Override
protected void onActivityResult(int requestCode, int resultCode, Intent data) {

super.onActivityResult(requestCode, resultCode, data);
final EditText phoneText = (EditText) findViewById(R.id.editText1);
switch (requestCode) {

case (1): {
    if (resultCode == Activity.RESULT_OK) {
        Uri contactData = data.getData();
        Cursor c = getContentResolver().query(contactData, new String[]{ContactsContract.CommonDataKinds.Phone.NUMBER}, null, null, null);
        if (c.moveToFirst())
        {
            int columnIndex = cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER)
            String phoneNum = c.getString(columnIndex);
            phoneText.setText(phoneNum);
        }
    }
    break;

}

}