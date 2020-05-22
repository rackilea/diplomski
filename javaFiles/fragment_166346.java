private void updateRecord(int phoneId,String number) {
    Uri uri = ContentUris.withAppendedId(Phones.CONTENT_URI, phoneId);
        values = new ContentValues();
        values.put(People.Phones.TYPE,People.Phones.TYPE_MOBILE);
        values.put(People.Phones.NUMBER, number);
        getContentResolver().update(uri, values, null, null);
    }