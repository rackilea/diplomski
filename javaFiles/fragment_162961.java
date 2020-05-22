//check if external storage is writable

    String state = Environment.getExternalStorageState();
    if (Environment.MEDIA_MOUNTED.equals(state)) {
        File file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES), fileName);
        if (!file.mkdirs()) {
            Log.e(LOG_TAG, "Directory not created");
        }else{
            //to wirte in storage
            FileOutputStream os = outStream = new FileOutputStream(file);
            String data = //put your data
            os.write(data.getBytes());
            os.close();
        }

    }