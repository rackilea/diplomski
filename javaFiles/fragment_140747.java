File fileOnSharedStorage = new File("/mnt/sdcard/libTest.so");
    File fileInProtectedStorage = new File("/data/data/com.package.myapp/extra/libTest.so");
    File folder = new File("/data/data/com.package.myapp/extra/");

    if (!folder.exists())
    {
      folder.mkdir();
    }

    if(!fileInProtectedStorage.exists())
    {
      try
      {
        copyFile(fileOnSharedStorage, fileInProtectedStorage);
      } catch (IOException e)
      {
        e.printStackTrace();
      }
    }

    System.load("/data/data/com.package.myapp/extra/libTest.so");