Date date = new Date();     
 date.getTime();
 SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd_HHmmss");
 String datetimestr = formatter.format(date);       
 lastPictureSaved = getContext().getFilesDir() + "/" + datetimestr + ".jpg";        
 File f = new File(lastPictureSaved);

 try
   {
    f.createNewFile();
   }
 catch (IOException e)
   {
    e.printStackTrace();

    Log.d(TAG, e.getMessage());
   }