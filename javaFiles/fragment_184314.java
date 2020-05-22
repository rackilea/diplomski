ImageView mImage;// YOUR IMAGEVIEW

    Drawable toRecycle = mImage.getDrawable();
            if ( toRecycle != null && toRecycle instanceof BitmapDrawable ) {
                if ( ( (BitmapDrawable) mImage.getDrawable() ).getBitmap() != null )
                    ( (BitmapDrawable) mImage.getDrawable() ).getBitmap().recycle();
            }
   mImage.setImageDrawable( null );