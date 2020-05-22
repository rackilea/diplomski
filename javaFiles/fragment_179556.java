public void agregarProducto(String nombre, String precio, String info, byte[] foto){
    SQLiteDatabase db=getWritableDatabase();
    if(db!=null){
        if(info.equals("Bebidas")){
            db.execSQL("INSERT INTO BEBIDAS VALUES('"+nombre+"','"+precio+"','"+info+"','"+foto+"')");
            db.close();
        }
    }
}