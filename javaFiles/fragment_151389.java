//Decode *.png file to Bitmap
            Bitmap Bitmap_temp = BitmapFactory.decodeResource(getResources(), R.drawable.image_1);
            Bitmap Bitmap_final = Bitmap_temp.copy(android.graphics.Bitmap.Config.ARGB_8888, true);

            //Get Pixel and change color if pixel color match
            int [] allpixels = new int [Bitmap_final.getHeight() * Bitmap_final.getWidth()];
            Bitmap_final.getPixels(allpixels, 0, Bitmap_final.getWidth(), 0, 0, Bitmap_final.getWidth(), Bitmap_final.getHeight());
            for(int i = 0; i < allpixels.length; i++)
            {
                if(allpixels[i] == Color.parseColor("#fff000"))
                {
                    allpixels[i] = Color.parseColor("#0D0D0D");
                }
            }
            Bitmap_final.setPixels(allpixels,0,Bitmap_final.getWidth(),0, 0, Bitmap_final.getWidth(),Bitmap_final.getHeight());

            //Set Bitmap to ImageView
            iv_image1.setImageBitmap(Bitmap_final);