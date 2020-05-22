// ...

final String SEPARATOR = ", ";

StringBuilder builder = new StringBuilder();
String prefix = "";

while(cursor.moveToNext()) {  
    builder.append(prefix);
    prefix = SEPARATOR;
    builder.append(cursor.getString(cursor.getColumnIndex(Tags.COLUMN_TNAME)));    
}  

String output = builder.toString()

// ...