DatabaseHandler db = new DatabaseHandler(AccountActivity.this);

    // getAllData();
    Cursor cursor = db.getData();

if (cursor.moveToFirst()) {
        do {
            Log.i("counttttttttttttt", "" + cursor.getCount());

            name = cursor.getString(0);
            email = cursor.getString(1);
            password = cursor.getString(2);
            birthdate = cursor.getString(3);
            pincode = cursor.getString(4);
            country = cursor.getString(5);
            paypal = cursor.getString(6);
            mobile = cursor.getString(7);
            fbid = cursor.getString(8);

        } while (cursor.moveToNext());
    }
db.close;