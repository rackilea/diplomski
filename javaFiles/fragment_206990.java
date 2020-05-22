Glide.with(mActivity)
     .load("your url")
     .listener(new RequestListener<String, GlideDrawable>() {
         @Override
         public boolean onException(Exception e, String model, Target<GlideDrawable> target, boolean isFirstResource) {
            return false;
         }

         @Override
         public boolean onResourceReady(GlideDrawable resource, String model, Target<GlideDrawable> target, boolean isFromMemoryCache, boolean isFirstResource) {
                return false;
         }
       })
     .into(mImgProfile);