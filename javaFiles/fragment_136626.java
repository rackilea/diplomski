ContentValues contentValues = new ContentValues();
Field[] fields = movie.getClass().getFields();
for(int i = 0; i < fields.length; i++)
{
        Class<?> fieldType = fields[i].getType();

        if(String.class.isAssignableFrom(fieldType)) {
            contentValues.put(allColumns[i], (String) fields[i].get(movie));
        } else if(Integer.class.isAssignableFrom(fieldType)) {
            contentValues.put(allColumns[i], (Integer) fields[i].get(movie));
        }
        ...and so on for all types
}