public static void clearCache(final Context context)
  {
  final File cache=context.getCacheDir();
  final File appDir=new File(cache.getParent());
  if(appDir.exists())
    {
    // you might be able to change this whole code block to just "deleteDir(appDir)"
    final String[] children=appDir.list();
    for(final String childFilePath : children)
      if(!childFilePath.equals("lib"))
        {
        deleteDir(new File(appDir,childFilePath));
        Log.i("TAG","**************** File /data/data/APP_PACKAGE/"+childFilePath+" DELETED *******************");
        }
    }
  }

public static boolean deleteDir(final File dir)
  {
  if(dir==null)
    return true;
  if(dir.isDirectory())
    {
    final String[] children=dir.list();
    for(final String childFilePath : children)
      {
      final boolean success=deleteDir(new File(dir,childFilePath));
      if(!success)
        return false;
      }
    }
  return dir.delete();
  }