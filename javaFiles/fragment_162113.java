File meta = new File(context.getAppContext().getFilesDir(),"meta")
meta.mkdirs();
File dir = new File(meta, "subdir");
dir.mkdirs(); //added
File imageFile = new File(dir, "filename.txt");
imageFile.createNewFile(); //added
FileOutputStream outputStream = new FileOutputStream(imageFile);