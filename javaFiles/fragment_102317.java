try {
        AssetFileDescriptor fd_description = getAssets().openFd("test.raw");
        String apk_path = getPackageResourcePath(); //maybe getPackageCodePath() ?
        RandomAccessFile file = new RandomAccessFile(apk_path, "r");
        file.seek(fd_description.getStartOffset());
        String value = file.readLine();
        Log.e("RAW ACCESS", "READ:" + value);
        file.seek(fd_description.getStartOffset());
        value = file.readLine();
        Log.e("RAW ACCESS", "READ:" + value);
    } catch (IOException exp){
        Log.e("RAW ACCESS", "ERROR:"+exp.toString());
    }