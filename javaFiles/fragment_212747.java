File DataDir = new File(Environment.getExternalStorageDirectory().getAbsolutePath()+File.separator+"/LocationData");
        if(!DataDir.exists())
        {
            try
            {
                DataDir.mkdir();
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }