Bitmap bitmap = null;

try{
bitmap =  BitmapFactory.decodeResource(getResources(), R.drawable.cleaf5, options);
}catch(OutOfMemoryError e)    
   try{
   BitmapFactory.Options options = new BitmapFactory.Options();
   options.inSampleSize = 8;
   bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.cleaf5, options);
   }catch(OutOfMemoryError e) {}
}

if(bitmap != null){
//do smth
}