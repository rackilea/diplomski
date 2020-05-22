String state = Environment.getExternalStorageState();
 if (Environment.MEDIA_MOUNTED.equals(state)) {
     File path = Environment.getDataDirectory();
     File file = new File(path, "text2.txt");
     // from here you read and write like you already did.
 }