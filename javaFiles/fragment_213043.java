if (android.os.Environment.getExternalStorageState().equals(android.os.Environment.MEDIA_MOUNTED))
        cacheDir=new File(android.os.Environment.getExternalStorageDirectory(),"MyCacheDir");
    else
        cacheDir=context.getCacheDir();
    if(!cacheDir.exists())
        cacheDir.mkdirs();