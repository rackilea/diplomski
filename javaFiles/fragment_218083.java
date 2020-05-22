Drawable drawable;
Picasso.with(this)
   .load("youUrl")
   .into(new Target() {
       @Override
       public void onBitmapLoaded(Bitmap bitmap, Picasso.LoadedFrom from) {
          drawable = new BitmapDrawable(getResources(), bitmap);
       }

       @Override
       public void onBitmapFailed(Drawable errorDrawable) {

       }

       @Override
       public void onPrepareLoad(Drawable placeHolderDrawable) {

       }
   });