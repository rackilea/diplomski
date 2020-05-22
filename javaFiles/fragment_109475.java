public void onClick(View v) {
List<AddressContent> contacts = GetAddresses();     
int counter = 0;        

if (!contacts.isEmpty()) {                  


    for (int i = 0; i < contacts.size(); i++) {             
ArrayList<ContentProviderOperation> ops = new ArrayList<ContentProviderOperation>();
        ops.add(ContentProviderOperation
                .newInsert(ContactsContract.RawContacts.CONTENT_URI)
                .withValue(ContactsContract.RawContacts.ACCOUNT_TYPE,
                        null)
                .withValue(ContactsContract.RawContacts.ACCOUNT_NAME,
                        null)
                .withValue(ContactsContract.RawContacts.AGGREGATION_MODE, 
                        ContactsContract.RawContacts.AGGREGATION_MODE_DISABLED).build());

        // ------------------------------------------------------ Name

        ops.add(ContentProviderOperation
                .newInsert(ContactsContract.Data.CONTENT_URI)
                .withValueBackReference(
                        ContactsContract.Data.RAW_CONTACT_ID, i)
                .withValue(
                        ContactsContract.Data.MIMETYPE,
                        ContactsContract.CommonDataKinds.StructuredName.CONTENT_ITEM_TYPE)
                .withValue(
                        ContactsContract.CommonDataKinds.StructuredName.DISPLAY_NAME,
                        contacts.get(i).getName()).build());

        // ------------------------------------------------------ Work
        // Number

        ops.add(ContentProviderOperation
                .newInsert(ContactsContract.Data.CONTENT_URI)
                .withValueBackReference(
                        ContactsContract.Data.RAW_CONTACT_ID, i)
                .withValue(
                        ContactsContract.Data.MIMETYPE,
                        ContactsContract.CommonDataKinds.Phone.CONTENT_ITEM_TYPE)
                .withValue(
                        ContactsContract.CommonDataKinds.Phone.NUMBER,
                        contacts.get(i).getPhone())
                .withValue(
                        ContactsContract.CommonDataKinds.Phone.TYPE,
                        ContactsContract.CommonDataKinds.Phone.TYPE_WORK)
                .build());

        // ------------------------------------------------------ Fax
        // Number

        ops.add(ContentProviderOperation
                .newInsert(ContactsContract.Data.CONTENT_URI)
                .withValueBackReference(
                        ContactsContract.Data.RAW_CONTACT_ID, i)
                .withValue(
                        ContactsContract.Data.MIMETYPE,
                        ContactsContract.CommonDataKinds.Phone.CONTENT_ITEM_TYPE)
                .withValue(
                        ContactsContract.CommonDataKinds.Phone.NUMBER,
                        contacts.get(i).getFax())
                .withValue(
                        ContactsContract.CommonDataKinds.Phone.TYPE,
                        ContactsContract.CommonDataKinds.Phone.TYPE_FAX_WORK)
                .build());

        // ------------------------------------------------------ Email

        ops.add(ContentProviderOperation
                .newInsert(ContactsContract.Data.CONTENT_URI)
                .withValueBackReference(
                        ContactsContract.Data.RAW_CONTACT_ID, i)
                .withValue(
                        ContactsContract.Data.MIMETYPE,
                        ContactsContract.CommonDataKinds.Email.CONTENT_ITEM_TYPE)
                .withValue(ContactsContract.CommonDataKinds.Email.DATA,
                        contacts.get(i).getEmail())
                .withValue(
                        ContactsContract.CommonDataKinds.Email.TYPE,
                        ContactsContract.CommonDataKinds.Email.TYPE_WORK)
                .build());

        // ------------------------------------------------------
        // Organisation

        ops.add(ContentProviderOperation
                .newInsert(ContactsContract.Data.CONTENT_URI)
                .withValueBackReference(
                        ContactsContract.Data.RAW_CONTACT_ID, i)
                .withValue(
                        ContactsContract.Data.MIMETYPE,
                        ContactsContract.CommonDataKinds.Organization.CONTENT_ITEM_TYPE)
                .withValue(
                        ContactsContract.CommonDataKinds.Organization.COMPANY,
                        contacts.get(i).getCompany())
                .withValue(
                        ContactsContract.CommonDataKinds.Organization.TYPE,
                        ContactsContract.CommonDataKinds.Organization.TYPE_WORK)
                .build());

        // ------------------------------------------------------
        // Address              

        ops.add(ContentProviderOperation
                .newInsert(ContactsContract.Data.CONTENT_URI)
                .withValueBackReference(
                        ContactsContract.Data.RAW_CONTACT_ID, i)
                .withValue(
                        ContactsContract.Data.MIMETYPE,
                        ContactsContract.CommonDataKinds.StructuredPostal.CONTENT_ITEM_TYPE)
                .withValue(
                        ContactsContract.CommonDataKinds.StructuredPostal.STREET, 
                        contacts.get(i).getStreet())
                .withValue(
                        ContactsContract.CommonDataKinds.StructuredPostal.CITY, 
                        contacts.get(i).getCity())
                .withValue(
                        ContactsContract.CommonDataKinds.StructuredPostal.POSTCODE, 
                        contacts.get(i).getPostcode())
                .withValue(
                        ContactsContract.CommonDataKinds.StructuredPostal.COUNTRY, 
                        contacts.get(i).getCountry())
                .withValue(
                        ContactsContract.CommonDataKinds.StructuredPostal.TYPE,
                        ContactsContract.CommonDataKinds.StructuredPostal.TYPE_WORK)
                .build());

    try {
        getContentResolver().applyBatch(ContactsContract.AUTHORITY,
                ops);
counter++;
    } catch (Exception e) {
        e.printStackTrace();
        Toast.makeText(this, "Error adding contact", Toast.LENGTH_SHORT).show();
        counter--;
    }
    }



    if (counter > 0) {
        if (counter > 1) {
            Toast.makeText(this, "Contacts added", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Contact added", Toast.LENGTH_SHORT).show();
        }
    }
}

if (counter == 0) {
    Toast.makeText(this, "Unable to add contact", Toast.LENGTH_SHORT).show();
}