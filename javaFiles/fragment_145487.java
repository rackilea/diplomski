File sdCard = Environment.getExternalStorageDirectory();
File dir = new File (sdcard.getAbsolutePath() + "/dir/subdir");  // in your case, just give /Methods

dir.mkdirs();
File file = new File(dir, "filename");  // in your case, just give "Method 1 Square.xml"

FileOutputStream f = new FileOutputStream(file);