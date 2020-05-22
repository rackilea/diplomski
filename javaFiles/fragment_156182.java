private TouchImageView mContentView;
private private SimpleTarget target;

mContentView = (TouchImageView) findViewById(R.id.fullscreen_content);

target = new SimpleTarget<Bitmap>() {
        @Override
   public void onResourceReady(Bitmap bitmap, GlideAnimation glideAnimation) 
{
            // do something with the bitmap
            // for demonstration purposes, let's just set it to an ImageView
            mContentView.setImageBitmap(bitmap);
        }
    };



    Glide.with(this) // could be an issue!
            .load( imagePath )
            .asBitmap()
            .into(target);