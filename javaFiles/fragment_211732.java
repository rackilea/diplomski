private void save(){ 
    SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss", Locale.ENGLISH);
    filename = sdf.format(new Date());

    try {
        String path = getApplicationContext().getFilesDir().getPath();
        OutputStream fOut = null;
        File file = new File(path, "MYFile"//your file name);
        if (!file.exists()) {
            file.mkdirs();
        }

        File file2 = new File(file, filename + ".png");
        fOut = new FileOutputStream(file2);


        //your bitmap
        original_with_water_mark.compress(Bitmap.CompressFormat.PNG, 100, fOut);
        fOut.flush();
        fOut.close();
    }
}