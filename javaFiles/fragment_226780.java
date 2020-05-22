String FILENAME = "test";
String string = "Date, Item, Quantity, Description,";

FileOutputStream fos = openFileOutput(FILENAME, Context.MODE_PRIVATE);
fos.write(string.getBytes());
fos.close();