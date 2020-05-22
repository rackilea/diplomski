ContentResolver cr = getContentResolver();

    String where = ContactsContract.Data.RAW_CONTACT_ID + " = ? AND " +
            ContactsContract.Data.MIMETYPE + " = ? ";
    String[] params = new String[] {idContact,
            ContactsContract.CommonDataKinds.StructuredName.CONTENT_ITEM_TYPE};

    Cursor phoneCur = managedQuery(ContactsContract.Data.CONTENT_URI, null, where, params, null);

    ArrayList<ContentProviderOperation> ops = new ArrayList<ContentProviderOperation>();

    if ( (null == phoneCur)  ) {
        //createContact(name, phone);

    } else {

        ops.add(ContentProviderOperation.newUpdate(ContactsContract.Data.CONTENT_URI)
                .withSelection(where, params)
                //.withValue(ContactsContract.CommonDataKinds.Phone.DATA, phone)
                .withValue(ContactsContract.CommonDataKinds.StructuredName.GIVEN_NAME, etName.getText().toString())
                .build());

    }

    phoneCur.close();

    try {
        cr.applyBatch(ContactsContract.AUTHORITY, ops);
    } catch (RemoteException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    } catch (OperationApplicationException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
}