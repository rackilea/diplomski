Open_CAM.setOnClickListener(new View.OnClickListener() {
    public void onClick(View v)  {
                Intent photoPickerIntent= new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                photoPickerIntent.putExtra(MediaStore.EXTRA_OUTPUT, getTempFile());
                photoPickerIntent.putExtra("outputFormat", Bitmap.CompressFormat.JPEG.toString());
                photoPickerIntent.putExtra("return-data", true);
                startActivityForResult(photoPickerIntent,TAKE_PICTURE);}}

 private Uri getTempFile() 
 {
      File root = new File(Environment.getExternalStorageDirectory(), "ServiceMySigns");
      if (!root.exists()) 
      {
          root.mkdirs();
      }
     final Calendar c = Calendar.getInstance();
     int y = c.get(Calendar.YEAR);
     int m = c.get(Calendar.MONTH);
     int d = c.get(Calendar.DAY_OF_MONTH);

     int h = c.get(Calendar.HOUR_OF_DAY);
     int mi = c.get(Calendar.MINUTE);

      //String filename=""+y+"-"+"-"+(m+1)+"-"+d+" "+h+":"+mi;
      String filename=""+System.currentTimeMillis();
      File file = new File(root,filename+".jpeg" );
      muri = Uri.fromFile(file);
      selectedImagePath=muri.getPath();
      Log.v("take picture path",selectedImagePath);
      return muri;
  }

  public void onActivityResult(int requestcode,int resultcode ,Intent data)
  {
      switch(requestcode)
      { 
      case TAKE_PICTURE: 
          if(resultcode==RESULT_OK)
          { 
              BitmapFactory.Options o = new BitmapFactory.Options();
              o.inSampleSize=8;
              Bitmap newImage = Bitmap.createScaledBitmap(BitmapFactory.decodeFile(selectedImagePath,o), 
                                                         150, 
                                                         150, 
                                                         false);}}}