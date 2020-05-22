Glide.with(context)
        .load(userdata.image)
        .placeholder(R.drawable.ic_male)
        .error(R.drawable.imagenotfound)
        .listener(new RequestListener<String, GlideDrawable>() {
            @Override
            public boolean onException(Exception e, String model, Target<GlideDrawable> target, boolean isFirstResource) {
                // log exception
                Log.e("TAG", handle error case", e);
                return false; 
            }

            @Override
            public boolean onResourceReady(GlideDrawable resource, String model, Target<GlideDrawable> target, boolean isFromMemoryCache, boolean isFirstResource) {
                 Log.e("TAG", handle success case here", e);
                return false;
            }
        })
        .into(headerView.imgNavDp);