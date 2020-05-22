private void getTotal() {
    int m=0;
    Cursor cursor = db.gettotal();
    if (cursor.getCount() == 0) {
        Toast.makeText(getApplicationContext(),"No message is available", Toast.LENGTH_LONG).show();
    } else {
        while (cursor.moveToNext()) {
            m += cursor.getInt(cursor.getColumnIndex("amount"));
        }
        total_amount.setText("" + m);
    }
}