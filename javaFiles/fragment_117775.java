private void getVcardString() {
    // TODO: 07.11.2017 Fix vCard Version
    vCardArray = new ArrayList<>();
    cursor = getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null,
            null, null, null);
    if (cursor != null && cursor.getCount() > 0) {
        cursor.moveToFirst();
        for (int i = 0; i < cursor.getCount(); i++) {

            String lookupKey = cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts.LOOKUP_KEY));
            Uri uri = Uri.withAppendedPath(ContactsContract.Contacts.CONTENT_VCARD_URI, lookupKey);
            AssetFileDescriptor fd;
            try {
                fd = this.getContentResolver().openAssetFileDescriptor(uri, "r");
                FileInputStream fis = fd.createInputStream();
                byte[] buf = new byte[(int) fd.getDeclaredLength()];
                fis.read(buf);
                String vCard = new String(buf);
                vCardArray.add(vCard);
                Log.println(Log.ASSERT, "Vcard", vCard);
            } catch (Exception e1) {
                e1.printStackTrace();
            }
            // you could save the file here using a FileOutputStream
            cursor.moveToNext();
        }

    } else {
        Log.d("vCardERROR", "No Contacts in Your Phone");
    }

}