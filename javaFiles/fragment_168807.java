ProgressDialog progressDialog= new ProgressDialog(this);
progressDialog.setMessage("Loading");
progressDialog.show();
if (image != null) { 
   Glide.with(this)
        .load(image)
        .placeholder(R.drawable.post_image)
        .listener(new RequestListener<String, GlideDrawable>() {
                         @Override
                         public boolean onException(Exception e, String model, Target<GlideDrawable> target, boolean isFirstResource) {
                             return false;
                         }

                         @Override
                         public boolean onResourceReady(GlideDrawable resource, String model, Target<GlideDrawable> target, boolean isFromMemoryCache, boolean isFirstResource) {
                            progressDialog.dismiss();
                             return false;
                         }
                     })
       .into(post_cover);
}