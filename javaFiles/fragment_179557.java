public long agregarProducto(String nombre, String precio, String info, byte[] foto){
    SQLiteDatabase db=getWritableDatabase();
    ContentValues cv = new ContentValues();

    if(db!=null){
        if(info.equals("Bebidas")){
            cv.put("NOMBRE",nombre);
            cv.put("PRECIO",precio);
            cv.put("INFO",info);
            cv.put("FOTO",foto);
            db.insert("BEBIDAS",null,cv);
            db.close();
        }
    }
}