while (pCur.moveToNext()) {
    phoneNo = pCur.getString(pCur.getColumnIndex(
            ContactsContract.CommonDataKinds.Phone.NUMBER));
    Log.i("TAG", "Name: " + name);
    Log.i("TAG", "Phone Number: " + phoneNo);
}