ArrayList<Bitmap> imgs = new ArrayList<Bitmap>();
   for(byte[] array: listByte)
   {
        Bitmap bm = BitmapFactory.decodeByteArray(array, 0, array.length); //use android built-in functions
        imgs.add(bm);
   }