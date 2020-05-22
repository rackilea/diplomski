String name = null;

    switch (reqCode) {
        case (REQUEST_CONTACT_PICKER):
            if (resultCode == Activity.RESULT_OK) {
                Uri contactData = data.getData();
                Cursor c = getContentResolver().query(contactData, null, null, null, null);
                if (c.moveToFirst()) {
                    name = c.getString(c.getColumnIndex(Phone.DISPLAY_NAME));
                }
            }
            break;
    }

    if (reqCode == REQUEST_CONTACT_PICKER) {
        if (resultCode == Activity.RESULT_OK) {
            if (data != null) {
                Uri contactData = data.getData();
                ArrayList <String> arrayList = new ArrayList<>();

                try {

                    ContentResolver cr = getContentResolver();
                    Cursor cur = cr.query(ContactsContract.Contacts.CONTENT_URI, null, null, null, null);
                    if (cur.getCount() > 0) {
                        while (cur.moveToNext()) {
                            String id = cur.getString(cur.getColumnIndex(ContactsContract.Contacts._ID));
                            String nameCheck = cur.getString(cur.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME));
                            //Log.d("NAMES", "name: " + name + "... nameCom: " + nameCheck);
                            if(!nameCheck.equals(name))continue;
                            Log.d("SUCCESS", "Name Chosen");
                            if (Integer.parseInt(cur.getString(cur.getColumnIndex(ContactsContract.Contacts.HAS_PHONE_NUMBER))) > 0) {
                                Cursor pCur = cr.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
                                        null, ContactsContract.CommonDataKinds.Phone.CONTACT_ID +" = ?",
                                        new String[]{id}, null);
                                while (pCur.moveToNext()) {
                                    int phoneType = pCur.getInt(pCur.getColumnIndex(ContactsContract.CommonDataKinds.Phone.TYPE));
                                    String phoneNumber = pCur.getString(pCur.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
                                    StringBuilder sb = new StringBuilder("Range of Numbers: ");
                                    switch (phoneType) {
                                        case Phone.TYPE_MOBILE:
                                            arrayList.add("Cell Number: " + phoneNumber);
                                            sb.append("MOBILE: " + phoneNumber + "; ");
                                            Log.e(name + "(mobile number)", phoneNumber);
                                            break;
                                        case Phone.TYPE_HOME:
                                            arrayList.add("Home Number: " + phoneNumber);
                                            sb.append("HOME: " + phoneNumber + "; ");
                                            Log.e(name + "(home number)", phoneNumber);
                                            break;
                                        case Phone.TYPE_WORK:
                                            arrayList.add("Work Number: " + phoneNumber);
                                            sb.append("WORK: " + phoneNumber + "; ");
                                            Log.e(name + "(work number)", phoneNumber);
                                            break;
                                        case Phone.TYPE_OTHER:
                                            arrayList.add("Misc Number: " + phoneNumber);
                                            sb.append("OTHER: " + phoneNumber + "; ");
                                            Log.e(name + "(other number)", phoneNumber);
                                            break;
                                        default:
                                            break;
                                    }
                                    //Toast.makeText(getBaseContext(), sb.toString(), Toast.LENGTH_SHORT).show();
                                }
                                pCur.close();


                                if(arrayList.isEmpty()){
                                    Toast.makeText(getBaseContext(), "No Phone Number Found", Toast.LENGTH_LONG).show();
                                } else if(arrayList.size() == 1){
                                    makeNewTxtAlarm(arrayList.get(0), name);
                                } else if (arrayList.size() > 1){
                                    selectNewTxtAlarmNumber(arrayList, name);
                                } else{
                                    Toast.makeText(getBaseContext(), "There is a problem with this contact...", Toast.LENGTH_LONG).show();
                                }
                            }
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    Toast.makeText(getBaseContext(), "There is a problem with this contact...", Toast.LENGTH_LONG).show();
                    Log.d("FILES", "Failed to get phone data");
                }
            }
        }
    }