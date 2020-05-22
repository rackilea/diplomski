private final Target myTarget = new Target() {
                    @Override
                    public void onBitmapLoaded(Bitmap bitmap, Picasso.LoadedFrom from) {
                        Log.d("MyLog", "BitmapLoaded");
                    }

                    @Override
                    public void onBitmapFailed(Exception e, Drawable errorDrawable)   {

                    }

                    @Override
                    public void onPrepareLoad(Drawable placeHolderDrawable) {

                    }
            }