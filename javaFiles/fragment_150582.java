@Override
    protected void onActivityResult(int requestCode, int resultCode, Intent intent){
        switch (requestCode){
            case PICK_CONTACT_REQUEST:
                if (resultCode == RESULT_OK){
                    Uri contactUri = intent.getData();
                    Cursor nameCursor = getContentResolver().query(contactUri, null, null, null, null);
                    if (nameCursor.moveToFirst()){
                        String name = nameCursor.getString(nameCursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));
                        String number = nameCursor.getString(nameCursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
                        ((EditText)findViewById(R.id.person_name)).setText(name);
                        ((EditText)findViewById(R.id.enter_mobile)).setText(number);
                        nameCursor.close();
                    }
                }
                break;
        }
    }