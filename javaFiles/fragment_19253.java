Uri contactData = data.getData();
            Cursor c = getActivity().getContentResolver().query(contactData, null, null, null, null);
            if (c.moveToFirst()) {
                String name = c.getString(c.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME));
                textcontact.setText(name + "\n");
                customerName = name;
                String contactId = c.getString(c.getColumnIndex(ContactsContract.Contacts._ID));
                String hasNumber = c.getString(c.getColumnIndex(ContactsContract.Contacts.HAS_PHONE_NUMBER));
                String num = "";
                if (Integer.valueOf(hasNumber) == 1) {
                    Cursor numbers = getActivity().getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null, ContactsContract.CommonDataKinds.Phone.CONTACT_ID + " = " + contactId, null, null);
                    while (numbers.moveToNext()) {
                        num = numbers.getString(numbers.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
                       textcontact.append(num + "\n");
                       phoneNumbers.add(num);
                    }
                }
            }