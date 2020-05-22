String fname = "VID_"+ timeStamp + ".3gp";

if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED))
{
   mediaFile = new File(android.os.Environment.getExternalStorageDirectory(),fname);
    if(!mediaFile.exists())
    {
         mediaFile.createNewFile();
    }
}

if(mediaFile.exists()){
       Log.v("mediaFile","ex");
   }else{
       Log.v("mediaFile","no ex");

   }