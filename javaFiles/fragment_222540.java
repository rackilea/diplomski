Cursor pCur2 = cr.query(ContactsContract.CommonDataKinds.StructuredPostal.CONTENT_URI, null,
                            ContactsContract.CommonDataKinds.Phone.CONTACT_ID + " = ?",
                            new String[]{id}, null);
                    while (pCur2.moveToNext())
                    {
                        String address = pCur2.getString(pCur2.getColumnIndex(ContactsContract.CommonDataKinds.StructuredPostal.FORMATTED_ADDRESS));
                        Log.d("tag", "Address: "+address);
                    }
                    pCur2.close();