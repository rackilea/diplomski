public void save (View view) {

    String newName = editText.getText().toString(); //Kullanıcının kardettiği isme bu şekilde ulaştık
    String newName2 = editText2.getText().toString();
    String newName3 = editText3.getText().toString();
    //image'ler bytearray şeklinde kaydedilir!!!!!!!!!!

    ByteArrayOutputStream outputStream = new ByteArrayOutputStream(); //selectedImage'i compress etmeliyiz kaydetme aşamalarından biri
    selectedImage.compress(Bitmap.CompressFormat.PNG,50,outputStream); //bu şekilde ziplemiş olduk resmi
    byte[] byteArray = outputStream.toByteArray(); //Bu outpuSteam'i al array'e çevir dedik! ve resmimiz kaydedilebilir oldu

    ContentValues cv = new ContentValues();
    cv.put("name",newName);
    cv.put("name2",newName2);
    cv.put("name3",newName3);
    cv.put("image",byteArray);
    long new_row_id = database.insert("yeni",null,cv);
    //<<<< ADDED TO ISSUE TOAST WITH THE RESULT
    if (new_row_id > 0) {
        Toast.makeText(this,"Row Insereted.",Toast.LENGTH_SHORT).show();
    } else {
        Toast.makeText(this,"Row NOT Inserted",Toast.LENGTH_SHORT).show();
    }
    /*
    try { //Tüm bu alttaki aşamalarda kullanıcının girdiği isim ve resmi database'imize işlemiş olduk!
        Log.d("SAVE","Attempting OPEN Or CREATE DATABASE");
        database = this.openOrCreateDatabase("Yeni", MODE_PRIVATE, null);
        Log.d("SAVE","Attempting CREATE OF TABLE yeni");
        database.execSQL("CREATE TABLE IF NOT EXISTS yeni (name VARCHAR, image BLOB)");

        String sqlString = "INSERT INTO yeni (name, image) VALUES (?, ?, ?, ?)";
        SQLiteStatement statement =database.compileStatement(sqlString);
        statement.bindString(1,newName);
        statement.bindString(3,newName2);
        statement.bindString(4,newName3);
        statement.bindBlob(2,byteArray);
        Log.d("SAVE","Attempting EXECUTION of the SQL INSERT using :- " + statement.toString());
        statement.execute();

    } catch (Exception e) {
        e.printStackTrace();
    }
    */
    Intent intent = new Intent(getApplicationContext(), MainActivity.class); //kaydet'e bastığında anasayfaya yönlendirilsin
    startActivity(intent);

    //this.finish(); //<<<< Should not start a parent activity you should return to it by finishing the child activity
}