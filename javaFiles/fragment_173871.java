btn.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub

                    readContacts(getApplicationContext());

            }
        });


      public void readContacts(Context ctx, String no) {

        ContentValues cvs   cvs = new ContentValues();
        Cursor phones = ctx.getContentResolver().query(
                ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null, null,
                null, ContactsContract.Contacts.DISPLAY_NAME + " ASC");
        if (phones.getCount() > 0) {
            while (phones.moveToNext()) {

                String phoneNumber = phones
                        .getString(phones
                                .getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
                if (!TextUtils.isEmpty(phoneNumber)) {
            String name = phones.getString(phones.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));

                cvs.put("name", name );
                cvs.put("phone_no", phoneNumber );


                }

            }

        }
                 insertItem(cvs, "readtables");


    }

private void insertItem(ContentValues cbs, String Tablename) {
        SQLiteDatabase db = dbl.getWritableDatabase();

        try {

            CreateTablenew(Tablename);


            db.insert("Tablename", null, cbs);


        } catch (SQLException e) {


        }
    }