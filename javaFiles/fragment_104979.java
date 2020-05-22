DataHelper dbHelper  = new DataHelper(this);

ton1.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View arg0) {

            SQLiteDatabase db = dbHelper.getWritableDatabase();
            cursor = db.rawQuery("SELECT * FROM pdil WHERE tiang = '" +
                    tiang.getText().toString() + "'", null);

            if (cursor.getCount() > 0) {
                Toast.makeText(getApplicationContext(), "Data Sudah Ada", Toast.LENGTH_LONG).show();
            } else if (rd1.isChecked()) {
                dbHelper.insertData(tiang.getText().toString(), String.valueOf(gps.getLatitude()), String.valueOf(gps.getLongitude()), rd1.getText().toString()); 

                Toast.makeText(getApplicationContext(), "Berhasil", Toast.LENGTH_LONG).show();
                MainActivity.ma.RefreshList();
                finish();
            }else if (rd2.isChecked()) {
                dbHelper.insertData(tiang.getText().toString(), String.valueOf(gps.getLatitude()), String.valueOf(gps.getLongitude()), rd2.getText().toString()); 

                Toast.makeText(getApplicationContext(), "Berhasil", Toast.LENGTH_LONG).show();
                MainActivity.ma.RefreshList();
                finish();
            }else if (rd3.isChecked()) {
                dbHelper.insertData(tiang.getText().toString(), String.valueOf(gps.getLatitude()), String.valueOf(gps.getLongitude()), rd3.getText().toString());      

                Toast.makeText(getApplicationContext(), "Berhasil", Toast.LENGTH_LONG).show();
                MainActivity.ma.RefreshList();
                finish();
            }
        };