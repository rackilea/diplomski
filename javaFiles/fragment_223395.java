Resources res = getResources(); //if you are in an activity
    AssetManager am = res.getAssets();
    String fileList[] = am.list(dirFrom);

    if (fileList != null)
    {   
        for ( int i = 0;i<fileList.length;i++)
        {
           Log.d("",fileList[i]); 
        }
    }