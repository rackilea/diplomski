target = new Target()
    {

        @Override
        public void onPrepareLoad(Drawable drawable) 
        {
        }

        @Override
        public void onBitmapLoaded(Bitmap photo, Picasso.LoadedFrom from)
        {
            cropEventImage(photo);
        }

        @Override
        public void onBitmapFailed(Drawable arg0) 
        {
        }
    };

    Picasso.with(this)
        .load(AppServer.getImageUrl() + "/" + eventInfo.getImageName())
        .placeholder(R.drawable.calendar)
        .error(R.drawable.calendar)
        .into(target);