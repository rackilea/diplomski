Class<?>[] models = {ModelName.class, OtherModelName.class};

for(Class<?> model : models){
    Method method = model.getMethod("createTable", SQLiteDatabase.class);
    method.invoke(null, new SQLiteDatabase());
    method = model.getMethod("deleteTable", SQLiteDatabase.class);
    method.invoke(null, new SQLiteDatabase());
}