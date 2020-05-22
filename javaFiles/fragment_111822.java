cursor = db.rawQuery("SELECT * FROM "+ DatabaseHelper.TABLE_NAME + " WHERE "+ DatabaseHelper.COL_3+ " =? AND "+ DatabaseHelper.COL_2+ "=?",new String[]{email, pass});
if (cursor.moveToFirst()){

    //db.rawQuery("SELECT * FROM "+ DatabaseHelper.TABLE_NAME + " WHERE "+ DatabaseHelper.COL_4+ " =?", new String[]{role});
    if (cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_4)).equals(test2)) {
        Toast.makeText(getApplicationContext(),"Success",Toast.LENGTH_SHORT).show();
        Intent i = new Intent(MainActivity.this, AdminMenu.class);
        cursor.close();
        startActivity(i);
    }
    else{
        Toast.makeText(getApplicationContext(),"Success",Toast.LENGTH_SHORT).show();
        Intent i = new Intent(MainActivity.this, UserMenu.class);
        cursor.close();
        startActivity(i);
    }

} else {
    Toast.makeText(getApplicationContext(),"Invalid email and/or password. Please try again.",Toast.LENGTH_SHORT).show();
    cursor.close();
}